package com.spring.boot.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigParamsController {
	
    @Autowired
    CacheManager cacheManager;
	
	@GetMapping(value = "/getConfigParams")
	public void get() {
		
		System.out.print(cacheManager.getCache("configParams").get("configParams").get().toString());
		 
	}

}
