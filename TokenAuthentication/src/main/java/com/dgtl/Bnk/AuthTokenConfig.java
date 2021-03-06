package com.dgtl.Bnk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.dgtl.Bnk.util.AuthTokenFilter;

@Component("authTokenConfig")
public class AuthTokenConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		AuthTokenFilter customFilter = new AuthTokenFilter(customUserDetailsService);
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
