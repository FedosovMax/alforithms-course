package com.algorithms.course.second.stack;


import java.util.EmptyStackException;
import java.util.Objects;
import java.util.stream.Stream;

public class Stack<T> {

    private Node<T> head;
    private int size = 0;

    public static <T> Stack<T> of(T... elements) {
        Stack<T> linkedStack = new Stack<>();
        Stream.of(elements).forEach(linkedStack::push);
        return linkedStack;
    }

    public void push(T element) {
        Objects.requireNonNull(element);
        Node<T> newNode = Node.valueOf(element);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public T pop() {
        if (head != null) {
            size--;
            return retrieveHead();
        } else {
            throw new EmptyStackException();
        }
    }

    private T retrieveHead() {
        T element = head.element;
        this.head = head.next;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
