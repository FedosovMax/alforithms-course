package com.algorithms.course.second.queue;

public class Node<T> {
    T element;
    Node<T> next;

    public static <T> Node<T> valueOf(T element) {
        return new Node<>(element);
    }

    private Node(T element) {
        this.element = element;
    }
}
