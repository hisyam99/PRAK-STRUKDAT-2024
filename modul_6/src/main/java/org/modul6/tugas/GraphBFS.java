package org.modul6.tugas;

import java.util.*;

public class GraphBFS {
    private int numVertices;
    private LinkedList<Integer>[] adjLists;
    private boolean[] visited;

    // Graph creation
    public GraphBFS(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // BFS algorithm
    void BFS(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adj : adjLists[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(12);

        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 7);
        g.addEdge(4, 10);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(5, 9);
        g.addEdge(6, 1);
        g.addEdge(7, 8);
        g.addEdge(7, 11);
        g.addEdge(8, 4);
        g.addEdge(11, 1);

        System.out.println("Breadth-First Search starting from node 1:");
        g.BFS(1);
    }
}
