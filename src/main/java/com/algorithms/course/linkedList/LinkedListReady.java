package com.algorithms.course.linkedList;

import java.util.Objects;
import java.util.stream.Stream;

public class LinkedListReady<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public <T> LinkedListReady<T> of(T... elements) {
        LinkedListReady<T> linkedList = new LinkedListReady<>();
        Stream.of(elements).forEach(linkedList::add);
        return linkedList;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T element) {
        Node<T> newNode = Node.valueOf(element);
        if (index == 0) {
            addAsHead(newNode);
        } else if (index == size) {
            addAsTail(newNode);
        } else {
            add(index, newNode);
        }
        size++;
    }

    private void addAsHead(Node<T> newNode) {
        newNode.next = head;
        head = newNode;
        if (head.next == null) {
            tail = head;
        }
    }

    private void addAsTail(Node<T> newNode) {
        tail.next = newNode;
        tail = newNode;
    }

    private void add(int index, Node<T> newNode) {
        Node<T> node = findNodeByIndex(index - 1);
        newNode.next = node.next;
        node.next = newNode;
    }

    private Node<T> findNodeByIndex(int index) {
        Objects.checkIndex(index, size);
        if (index == size - 1) {
            return tail;
        } else {
            return nodeAt(index);
        }
    }

    private Node<T> nodeAt(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void set(int index, T element) {
        Node<T> node = findNodeByIndex(index);
        node.element = element;
    }

    public T get(int index) {
        Node<T> node = findNodeByIndex(index);
        return node.element;
    }

    public T remove(int index) {
        T deletedElement;
        if (index == 0 && !isEmpty()) {
            deletedElement = head.element;
            removeHead();
        } else {
            Node<T> previousNode = findNodeByIndex(index - 1);
            deletedElement = previousNode.next.element;
            previousNode.next = previousNode.next.next;
            if (index == size - 1) {
                tail = previousNode;
            }
        }
        size--;
        return deletedElement;
    }

    private void removeHead() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    public boolean contains(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.element.equals(element)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

}
