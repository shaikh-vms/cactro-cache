package com.cactro.cache.test;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.cactro.cache.api.model.CacheData;
import com.cactro.cache.api.service.CactroCacheService;

public class CacheTest {

	@Test
	public void sampleTest() {
		System.out.println("test called success");
	}
	
	@Test
	public void testCacheEviction() throws InterruptedException {
	    CactroCacheService cache = new CactroCacheService(); // 1 second TTL
	  
	    CacheData cacheData = new CacheData();
	    cacheData.setKey("key1");
	    cacheData.setValue("value1");
	    cacheData.setExpireAfterMiliseconds("1000");
	    
	    cache.putCache(cacheData);
	    
	    Thread.sleep(1100);
	    assertNull(cache.getCache("key1"));
	}
}
