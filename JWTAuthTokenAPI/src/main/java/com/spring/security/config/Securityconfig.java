package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.security.securityFilter.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity      // Enables security for our application.
public class Securityconfig extends WebSecurityConfigurerAdapter {
 
    // Securing the urls and allowing role-based access to these urls.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers("/user").hasRole("USER")
        .anyRequest().authenticated()
        .and().csrf().ignoringAntMatchers("/user");
    }
 
    // In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("guest").password("{noop}guest1234").roles("USER");
    }
}