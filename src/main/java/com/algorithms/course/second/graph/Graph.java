package com.algorithms.course.second.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph<T> {

    List<List<Node<T>>> adj_list = new ArrayList<>();

    public Graph(List<Edge<T>> edges) {
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());

        for (Edge<T> e : edges) {
            adj_list.get(e.source).add(new Node<T>(e.destination));
        }
    }

    public void printGraph()  {
        int src_vertex = 0;
        int list_size = adj_list.size();

        while (src_vertex < list_size) {
            for (Node<T> edge : adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " --> " + edge.value + ")\t");
            }

            System.out.println();
            src_vertex++;
        }
    }

    public static void main (String[] args)    {
        List<Edge<Integer>> edges = Arrays.asList(
                new Edge<>(0, 1),
                new Edge<>(0, 2),
                new Edge<>(1, 2),
                new Edge<>(2, 0),
                new Edge<>(2, 1),
                new Edge<>(3, 2),
                new Edge<>(4, 5),
                new Edge<>(5, 4)
        );

        Graph<Integer> graph = new Graph<>(edges);
        graph.printGraph();
    }
}
