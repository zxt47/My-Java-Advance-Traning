package com.xtzhou.ehcache.demo;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;

public class EhcacheServiceDemo {
    CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();

}
