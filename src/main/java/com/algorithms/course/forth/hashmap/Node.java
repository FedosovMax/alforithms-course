package com.algorithms.course.forth.hashmap;

import java.util.Map;
import java.util.Objects;

class Node<K, V> {
    final K key;
    V value;
    Node<K, V> next;

    Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final V getValue() {
        return value;
    }

    public final String toString() {
        return key + "=" + value;
    }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}
