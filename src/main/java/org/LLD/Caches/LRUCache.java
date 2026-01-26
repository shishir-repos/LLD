package org.LLD.Caches;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Initialize Dummy Nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insertAtHead(node); // Move to MRU position
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        if (cache.size() == capacity) {
            // Evict LRU (node before dummy tail)
            cache.remove(tail.prev.key);
            remove(tail.prev);
        }

        Node newNode = new Node(key, value);
        insertAtHead(newNode);
        cache.put(key, newNode);
    }

    // Helper: Remove node from its current DLL position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Insert node right after dummy head (MRU position)
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
