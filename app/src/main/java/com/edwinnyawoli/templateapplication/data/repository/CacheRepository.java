package com.edwinnyawoli.templateapplication.data.repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */

@Singleton
public class CacheRepository {

    private Map<String, Object> cache;

    @Inject
    public CacheRepository() {
        cache = new HashMap<>();
    }

    public void put(String key, Object object) {
        cache.put(key, object);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) cache.get(key);
    }

}
