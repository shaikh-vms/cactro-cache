package com.cactro.cache.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cactro.cache.api.model.CacheData;
import com.cactro.cache.api.service.CactroCacheService;

@RestController
@RequestMapping("/cache")
public class CactroCacheController {

    @Autowired
    private CactroCacheService cacheService;

    @PostMapping
    public String storeCache(@RequestBody CacheData cache) {
        return cacheService.putCache(cache);
    }

    @GetMapping("/{key}")
    public Object getCache(@PathVariable String key) {
        return cacheService.getCache(key);
    }

    @DeleteMapping("/{key}")
    public String removeCache(@PathVariable String key) {
        return cacheService.removeCache(key);
    }
}
