package com.algorithms.course.third.breathfirstsearch;

import java.util.*;

public class BreathFirstSearch {

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public List<String> breathFirstValues(Node<Character> root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Node<Character>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Character> current = queue.poll();
            result.add(current.toString());
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var a = new Node<>('a');
        var b = new Node<>('b');
        var c = new Node<>('c');
        var d = new Node<>('d');
        var e = new Node<>('e');
        var f = new Node<>('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        BreathFirstSearch depthFirstSearch = new BreathFirstSearch();
        depthFirstSearch.breathFirstValues(a).forEach(System.out::println);
    }
}
