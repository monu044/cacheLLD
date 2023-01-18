package com.monu.localCache;

import com.monu.localCache.cache.Cache;
import com.monu.localCache.cache.evictionPolicy.LRUEvictionPolicy;
import com.monu.localCache.cache.storage.HashMapBasedStorage;

public class Main {

    public static void main(String[] args) {
        Integer capacity = 3;
        Cache<Integer, String> cache = new Cache<>(new LRUEvictionPolicy<>(), new HashMapBasedStorage<Integer, String>(), capacity);
        cache.put(1, "Monu");
        cache.put(2, "Ravi");
        cache.put(3, "Sourav");
        System.out.println(cache.getKey(1));
        cache.put(1, "Javed");
        cache.put(5, "Sourav");
        cache.put(2, "Hemant");
        System.out.println(cache.getKey(2));
    }
}
