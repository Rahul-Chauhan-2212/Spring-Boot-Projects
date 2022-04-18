package com.dgtl.Bnk.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgtl.Bnk.model.request.AuthenticationRequest;
import com.dgtl.Bnk.model.response.UserTransfer;
import com.dgtl.Bnk.template.rest.response.ResponseMessage;
import com.dgtl.Bnk.util.AuthTokenUtil;
import com.dgtl.Bnk.util.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	
	@Autowired
	HttpServletRequest req;

	@RequestMapping(value = "/authenticate", method = { RequestMethod.POST })
	@ApiOperation(value = "authenticate")
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SUCCESS, response = UserTransfer.class),
			@ApiResponse(code = 403, message = Constants.FORBIDDEN),
			@ApiResponse(code = 422, message = Constants.USER_NOT_FOUND),
			@ApiResponse(code = 417, message = Constants.EXCEPTION_FAILED) })
	public ResponseEntity<ResponseMessage> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			String username = authenticationRequest.getUsername();
			String password = authenticationRequest.getPassword();

			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = this.authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

			List<String> roles = new ArrayList<>();

			for (GrantedAuthority authority : userDetails.getAuthorities()) {
				roles.add(authority.toString());
			}
            ResponseMessage responseMessage = new ResponseMessage();
            Map<String, Object> responseAttributes = new LinkedHashMap<>();
            responseAttributes.put("x-auth-token", AuthTokenUtil.createToken(userDetails));
            responseAttributes.put("csrfToken", ((CsrfToken)req.getSession().getAttribute("csrfToken")).getToken());
            responseAttributes.put("userName", userDetails.getUsername());
            responseAttributes.put("roles", roles);
            

            responseMessage.setBody((Serializable)Collections.unmodifiableMap(responseAttributes));
            return ResponseEntity.ok(responseMessage);
			/*return new ResponseEntity<UserTransfer>(new UserTransfer(userDetails.getUsername(), roles,
					AuthTokenUtil.createToken(userDetails),csrfTokenUtil.loadToken(req).getToken(), HttpStatus.OK), HttpStatus.OK);*/

		} catch (BadCredentialsException bce) {
			//return new ResponseEntity<UserTransfer>(new UserTransfer(), HttpStatus.NO_CONTENT);
			 ResponseMessage responseMessage = new ResponseMessage();
	         Map<String, Object> responseAttributes = new LinkedHashMap<>();
	         responseAttributes.put("message", "Bad Credentials");
	            responseMessage.setBody((Serializable)Collections.unmodifiableMap(responseAttributes));
			return ResponseEntity.ok(responseMessage);

		} catch (Exception e) {
			 ResponseMessage responseMessage = new ResponseMessage();
	         Map<String, Object> responseAttributes = new LinkedHashMap<>();
	         responseAttributes.put("message", "Exception Occured");
	            responseMessage.setBody((Serializable)Collections.unmodifiableMap(responseAttributes));
				return ResponseEntity.ok(responseMessage);
			//return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	

}
