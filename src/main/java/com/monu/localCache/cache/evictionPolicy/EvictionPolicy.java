package com.monu.localCache.cache.evictionPolicy;

public interface EvictionPolicy<K> {

    void keyAccessed(K key);

    K getKeyToBeRemoved();
}
