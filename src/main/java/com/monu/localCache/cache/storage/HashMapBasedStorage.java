package com.monu.localCache.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<K, V> implements Storage <K, V> {

    private Map<K, V> storage;

    public HashMapBasedStorage () {
        this.storage = new HashMap<>();
    }

    @Override
    public boolean add(K key, V value) {
        storage.put(key, value);
        return true;
    }

    @Override
    public V get(K key) {
        return storage.get(key);
    }

    @Override
    public V delete(K key) {
        V value = storage.get(key);
        storage.remove(key);
        return value;
    }

    public int getCurrentSize() {
        return storage.size();
    }
}
