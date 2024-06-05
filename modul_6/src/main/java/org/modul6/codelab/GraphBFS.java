package org.modul6.codelab;

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
        adjLists[dest].add(src);  // As it is an undirected graph
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
        GraphBFS g = new GraphBFS(6);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(1, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        // g.addEdge(4, 5);

        System.out.println("Breadth-First Search starting from node 3:");
        g.BFS(3);
    }
}
