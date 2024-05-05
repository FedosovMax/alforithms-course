package com.algorithms.course.third.depthfirstsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchRecursion {

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
        if (root == null) {
            return Collections.emptyList();
        }
        List<String> leftValues = depthFirstValues(root.left); // b, d, e
        List<String> rightValues = depthFirstValues(root.right); // c, f

        result.add(root.value.toString());
        result.addAll(leftValues);
        result.addAll(rightValues);
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

        DepthFirstSearchRecursion depthFirstSearch = new DepthFirstSearchRecursion();
        depthFirstSearch.depthFirstValues(a).forEach(System.out::println);
    }
}
