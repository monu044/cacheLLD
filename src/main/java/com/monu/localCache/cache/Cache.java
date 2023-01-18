package com.monu.localCache.cache;

import com.monu.localCache.cache.evictionPolicy.EvictionPolicy;
import com.monu.localCache.cache.storage.Storage;

import java.util.Optional;

public class Cache <K, V> {

    private final EvictionPolicy<K> evictionPolicy;

    private final Storage<K, V> storage;

    private Integer capacity;


    public Cache (EvictionPolicy<K> evictionPolicy, Storage storage, Integer capacity) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
        this.capacity = capacity;
    }

    public V getKey(K key) {
        V value = storage.get(key);
        if (null != value) {
            evictionPolicy.keyAccessed(key);
            return value;
        }
        else {
            System.out.println("Key : " + key + " is not in cache");
            return null;
        }
    }

    public boolean put(K key, V value) {
        V oldValue = storage.get(key);
        if (null == oldValue) {
            if (storage.getCurrentSize() == capacity) {
                K keyToBeRemoved = evictionPolicy.getKeyToBeRemoved();
                storage.delete(keyToBeRemoved);
            }
        }
        else {
            storage.delete(key);
        }
        evictionPolicy.keyAccessed(key);
        return storage.add(key, value);
    }
}
