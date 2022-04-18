package com.dgtl.Bnk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;

import com.dgtl.Bnk.util.CsrfTokenRefresher;
import com.dgtl.Bnk.util.CsrfTokenResponseHeaderBindingFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	@Autowired
	@Qualifier("authTokenConfig")
	private AuthTokenConfig authTokenConfig;
	
	@Autowired
	private XAuthTokenConfig xauthTokenConfig;
	
	@Autowired
	private CsrfTokenRefresher csrfTokenRefresher;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] methodSecured = { "/users/*"/* ,"/swagger-ui.html" */};
		
	     
		 http.authorizeRequests()
		.antMatchers("/","/login/authenticate").permitAll()
		.antMatchers(methodSecured).authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/welcome").failureUrl("/login?error=true").permitAll()
		.and().logout().deleteCookies("JSESSIONID").logoutUrl("/logout").logoutSuccessUrl("/login"); 
	     http.apply(authTokenConfig);
	     http.apply(xauthTokenConfig);
	     //http.csrf().disable();
	     http.csrf().ignoringAntMatchers("/","/login/authenticate");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
