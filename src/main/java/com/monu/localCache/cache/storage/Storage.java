package com.monu.localCache.cache.storage;

public interface Storage <K, V> {

    boolean add(K key, V value);

    V get(K key);

    V delete(K key);

    int getCurrentSize();
}
