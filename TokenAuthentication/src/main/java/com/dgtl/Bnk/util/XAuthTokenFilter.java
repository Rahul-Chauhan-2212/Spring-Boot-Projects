package com.dgtl.Bnk.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

public class XAuthTokenFilter extends GenericFilterBean{
	
	private String authTokenHeaderName = "_csrfToken";
	
	private CsrfTokenUtil csrfTokenUtil= new CsrfTokenUtil();

	public XAuthTokenFilter() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
			String csrfToken = httpServletRequest.getHeader(authTokenHeaderName);

			if (StringUtils.hasText(csrfToken)) {
				
				CsrfToken savedCsrfToken=csrfTokenUtil.loadToken(httpServletRequest);
				if(savedCsrfToken.getToken().compareTo(csrfToken)==0)
						{
					
						}
				else
				{
					throw new InternalAuthenticationServiceException("Unable to authenticate Domain User for provided credentials");
				}
			}

			filterChain.doFilter(servletRequest, servletResponse);
		}catch (InternalAuthenticationServiceException internalAuthenticationServiceException) {
            SecurityContextHolder.clearContext();
            servletResponse.getWriter().append("Authentication Token Not Valid");
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
