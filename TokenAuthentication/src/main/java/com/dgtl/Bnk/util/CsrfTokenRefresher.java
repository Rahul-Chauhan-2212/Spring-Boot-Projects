package com.dgtl.Bnk.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CsrfTokenRefresher extends OncePerRequestFilter {
	
	@Autowired
	private CsrfTokenRepository csrfTokenRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		csrfTokenRepo.saveToken(null, request, response);
		CsrfToken newToken=csrfTokenRepo.generateToken(request);
		csrfTokenRepo.saveToken(newToken, request, response);
		request.setAttribute(CsrfToken.class.getName(), newToken);
		request.setAttribute(newToken.getParameterName(), newToken);
		filterChain.doFilter(request, response);

	}

}
