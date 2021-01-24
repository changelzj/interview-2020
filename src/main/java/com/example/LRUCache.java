package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 双链表加哈希实现最近最少使用算法
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(4, 4);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(5, 5);
        System.out.println(lruCache.map.keySet());
    }


    private int capacity;

    private Map<Integer, Node<Integer, Integer>> map;

    private DoubleLinkedList<Integer, Integer> linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        linkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            linkedList.removeNode(node);
            linkedList.addHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        //更新
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.val = value;
            linkedList.removeNode(node);
            linkedList.addHead(node);
        }
        //新增
        else {
            if (map.size() == this.capacity) {
                Node<Integer, Integer> node = linkedList.last();
                linkedList.removeNode(node);
                map.remove(node.key);
            }
            Node<Integer, Integer> node = new Node<>(key, value);
            linkedList.addHead(node);
            map.put(key, node);
        }
    }



}


class Node<K, V> {
    K key;
    V val;
    Node<K, V> prev;
    Node<K, V> next;
    public Node() {

    }
    public Node(K key, V val) {
        this.key = key;
        this.val = val;
    }
}


class DoubleLinkedList<K, V> {
    Node<K, V> head;
    Node<K, V> tail;

    public DoubleLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public void addHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public Node<K, V> last() {
        return tail.prev;
    }



}