package com.algorithms.course.first.linkedLists;


public class Node<T> {
    T element;
    Node<T> next;

    public Node(T element) {
        this.element = element;
    }

    public static <T> Node<T> valueOf(T value) {
        return new Node<>(value);
    }
}
