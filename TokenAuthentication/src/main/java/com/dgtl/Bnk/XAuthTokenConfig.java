package com.dgtl.Bnk;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.stereotype.Component;

import com.dgtl.Bnk.util.XAuthTokenFilter;

@Component
public class XAuthTokenConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{

	@Override
	public void configure(HttpSecurity builder) throws Exception {
		// TODO Auto-generated method stub
		XAuthTokenFilter xAuthTokenFilter = new XAuthTokenFilter();
		builder.addFilterBefore(xAuthTokenFilter, CsrfFilter.class);
	}

	
	
}
