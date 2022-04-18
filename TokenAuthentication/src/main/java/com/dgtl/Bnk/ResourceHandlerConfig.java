package com.dgtl.Bnk;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ResourceHandlerConfig implements WebMvcConfigurer  {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html**")
				.addResourceLocations("classpath:/resources/swagger-ui.html");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/resources/webjars/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/welcome").setViewName("welcome");
		registry.addViewController("/").setViewName("login");
	}
}