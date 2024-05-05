package com.algorithms.course.third.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node (T value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public List<String> depthFirstValues (Node<Character> root) {
        List<String> result = new ArrayList<>();
        Stack<Node<Character>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node<Character> current = stack.pop();
            result.add(current.toString());

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
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

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        List<String> result = depthFirstSearch.depthFirstValues(a);
        result.forEach(System.out::println);
    }
}
