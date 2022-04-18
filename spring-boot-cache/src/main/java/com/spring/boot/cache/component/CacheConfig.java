package com.spring.boot.cache.component;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.cache.persistence.ConfigParamsRepository;

@Configuration
@EnableCaching
public class CacheConfig
{

	@Autowired
	ConfigParamsRepository repository;
	
    @Bean
    public CacheManager cacheManager()
    {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(createCache()));
        return cacheManager;
    }
    
    @PostConstruct
    public Cache createCache()
    {
        Cache cache = new ConcurrentMapCache("configParams");
        cache.put("configParams", repository.findAll());
        return cache;
    }
}