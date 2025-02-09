package com.cactro.cache.api.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import com.cactro.cache.api.model.CacheData;

@Service
public class CactroCacheService {

	private static final int MAX_SIZE = 10;
	private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<String, Long> expirationTimes = new ConcurrentHashMap<>();

	public String putCache(CacheData cacheData) {

		// check size
		if (cache.size() >= MAX_SIZE)
			throw new UnsupportedOperationException("cache size exceeding....!");

		String key = cacheData.getKey();
		Object value = cacheData.getValue();

		// put in cache
		cache.put(key, value);

		// get TTL
		Integer ttl = 60000;// default 1 minute if wrong value
		try {
			ttl = NumberUtils.parseNumber(cacheData.getExpireAfterMiliseconds(), Integer.class);
		} catch (IllegalArgumentException e) {
			// NOP
		}

		// put TTL
		expirationTimes.put(key, System.currentTimeMillis() + ttl);

		return key;
	}

	public Object getCache(String key) {
		if (isExpired(key)) {
			cache.remove(key);
			expirationTimes.remove(key);
			return null;
		}
		return cache.get(key);
	}

	public String removeCache(String key) {
		cache.remove(key);
		expirationTimes.remove(key);
		return "removed " + key;
	}

	private boolean isExpired(String key) {
		Long expirationTime = expirationTimes.get(key);
		return expirationTime == null || System.currentTimeMillis() > expirationTime;
	}

	@Scheduled(fixedRate = 1, initialDelay = 1, timeUnit = TimeUnit.MINUTES)
	public void invokeCleanup() {
		for (String key : cache.keySet()) {
			if (isExpired(key)) {
				removeCache(key);
            }
		}
	}
}
