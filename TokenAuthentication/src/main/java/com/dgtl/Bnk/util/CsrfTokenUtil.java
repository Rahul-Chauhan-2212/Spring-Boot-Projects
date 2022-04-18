package com.dgtl.Bnk.util;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

@Component
public class CsrfTokenUtil implements CsrfTokenRepository {
	
	static final String headerName ="csrfToken";
	static final String parameterName ="csrfParam";
	static final String cookieName ="USER_INFO";
	static final String sessionAttributeName ="csrfToken";


	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Cookie cookie = WebUtils.getCookie(request, cookieName);
		if(cookie == null)
		{
			return new DefaultCsrfToken(headerName, parameterName, createNewToken());
		}
		String cookieValue = cookie.getValue();
		String token = cookieValue.split("\\|")[0];
		if(!StringUtils.hasLength(token)) {
			return new DefaultCsrfToken(headerName, parameterName, token);
		}
		return new DefaultCsrfToken(headerName, parameterName, createNewToken());
	}

	@Override
	public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(token==null)
		{
			HttpSession session = request.getSession(false);
			if(session!=null) {
				session.removeAttribute(sessionAttributeName);
			}
		}else {
			request.setAttribute(headerName, token);
			request.getSession().setAttribute(sessionAttributeName, token);
		}
		
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(request.getSession(false)==null) {
			return null;
		}
		return (CsrfToken) request.getSession().getAttribute(sessionAttributeName);
	}
	
	private String createNewToken() {
		return UUID.randomUUID().toString();
	}

}
