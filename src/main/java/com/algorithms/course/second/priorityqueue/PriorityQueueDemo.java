package com.algorithms.course.second.priorityqueue;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        Queue<Integer> queue = new PriorityQueue<>(List.of(15, 4, 1, 5, 3, 2, 9));

        queue.offer(25);

        queue.forEach(q -> System.out.println(queue.poll()));
    }
}
