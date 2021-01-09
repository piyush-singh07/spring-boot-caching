package com.myorg.cacheconfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
public class MyCacheConfig extends CachingConfigurerSupport {

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		CacheConfiguration tenSecCacheConfig = new CacheConfiguration();
		tenSecCacheConfig.setName("ten-secs-cache");
		tenSecCacheConfig.setMaxEntriesLocalHeap(1000);
		tenSecCacheConfig.setMemoryStoreEvictionPolicy("LRU");
		tenSecCacheConfig.setTimeToLiveSeconds(10);

		CacheConfiguration twentySecCacheConfig = new CacheConfiguration();
		twentySecCacheConfig.setName("twenty-secs-cache");
		twentySecCacheConfig.setMaxEntriesLocalHeap(1000);
		twentySecCacheConfig.setMemoryStoreEvictionPolicy("LRU");
		twentySecCacheConfig.setTimeToLiveSeconds(20);

		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(tenSecCacheConfig);
		config.addCache(twentySecCacheConfig);
		return new net.sf.ehcache.CacheManager().newInstance(config);
	}

}
