package design.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null) {
            return -1;
        }

        remove(node);
        addToEnd(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;

            remove(node);
            addToEnd(node);

            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToEnd(newNode);

        if (map.size() > capacity) {
            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToEnd(Node node) {
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }

    static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // evicts key 2

        System.out.println(cache.get(2)); // -1

        cache.put(4, 4); // evicts key 1

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
