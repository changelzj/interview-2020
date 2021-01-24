package com.example;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    public static void main(String[] args) {
        SimpleLRUCache<Integer, String> lruCache = new SimpleLRUCache<>(3);
        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");
        System.out.println(lruCache.keySet());
        lruCache.put(4, "D");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "C");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "C");
        System.out.println(lruCache.keySet());
        lruCache.put(3, "C");
        System.out.println(lruCache.keySet());
        lruCache.put(5, "D");
        System.out.println(lruCache.keySet());
    }




    private int capacity;

    public SimpleLRUCache(int capacity) {
        super(capacity, 0.75f, true);//true访问顺序  false插入顺序
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }


}
