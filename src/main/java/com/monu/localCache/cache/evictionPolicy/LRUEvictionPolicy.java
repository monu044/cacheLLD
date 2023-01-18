package com.monu.localCache.cache.evictionPolicy;

import java.util.*;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private Map<K, Integer> keyMap;

    public LRUEvictionPolicy () {
        this.keyMap = new LinkedHashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if (Boolean.TRUE.equals(keyMap.containsKey(key))) {
            keyMap.remove(key);
        }
        keyMap.put(key, 1);
    }

    @Override
    public K getKeyToBeRemoved() {
        K key = keyMap.entrySet().iterator().next().getKey();
        keyMap.remove(key);
        return key;
    }
}
