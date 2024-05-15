package com.algorithms.course.forth.hashmap;

import static java.util.Objects.requireNonNull;

public class MyHashMap<K,V> {

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    private static final float RESIZE_THRESHOLD = 1.0f;
    transient Node<K, V>[] table;
    transient int size;

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity) {
        verifyCapacity(initialCapacity);
        this.table = new Node[initialCapacity];
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        var index = calculateIndex(requireNonNull(key), table.length);
        var current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private static int calculateIndex(Object key, int tableCapacity) {
        var hash = key.hashCode() ^ (key.hashCode() >> 16);
        return hash & (tableCapacity - 1);
    }

    private void resizeIfNeeded() {
        if (size / (float) table.length > RESIZE_THRESHOLD) {
            resize(2 * table.length);
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V put(K key, V value) {
        resizeIfNeeded();
        return putVal(table, key, value);
    }

    private V putVal(Node<K, V>[] table, K key, V value) {
        Node<K, V> newNode = newNode(key, value, null);
        int index = calculateIndex(key, table.length);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    var prevValue = current.value;
                    current.value = value;
                    return prevValue;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                V prevValue = current.value;
                current.value = value;
                return prevValue;
            }
            current.next = newNode;
        }
        size++;
        return null;
    }

    Node<K,V> newNode(K key, V value, Node<K,V> next) {
        return new Node<>(key, value, next);
    }

    public void resize(int newCapacity) {
        verifyCapacity(newCapacity);
        @SuppressWarnings("unchecked") Node<K, V>[] newTable = new Node[newCapacity];
        size = 0;
        for (Node<K,V> head : table) {
            Node<K,V> current = head;
            while (current != null) {
                putVal(newTable, current.key, current.value);
                current = current.next;
            }
        }
        table = newTable;
    }

    private void verifyCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity (table array size) must be positive");
        }
    }

    public V remove(Object key) {
        int index = calculateIndex(requireNonNull(key), table.length);
        Node<K,V> current = table[index];
        if (current != null) {
            if (current.key.equals(key)) {
                V value = current.value;
                table[index] = current.next;
                size--;
                return value;
            }
            while (current.next != null) {
                if (current.next.key.equals(key)) {
                    V value = current.next.value;
                    current.next = current.next.next;
                    size--;
                    return value;
                }
                current = current.next;
            }
        }
        return null;
    }

    public boolean containsValue(Object value) {
        for (Node<K,V> head : table) {
            Node<K,V> current = head;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

}
