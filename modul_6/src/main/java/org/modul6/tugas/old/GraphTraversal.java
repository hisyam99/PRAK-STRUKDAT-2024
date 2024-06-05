package org.modul6.tugas.old;

import java.util.*;

public class GraphTraversal {

    // Representasi graf menggunakan adjacency list
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    // Fungsi untuk menambahkan edge ke graf
    private static void addEdge(int source, int destination) {
        graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }

    // Implementasi DFS
    private static List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                List<Integer> neighbors = graph.get(node);
                if (neighbors != null) {
                    Collections.reverse(neighbors); // Untuk mendapatkan urutan yang benar
                    for (int neighbor : neighbors) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }

    // Implementasi BFS
    private static List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                result.add(node);
                List<Integer> neighbors = graph.get(node);
                if (neighbors != null) {
                    queue.addAll(neighbors);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Menambahkan edges ke graf
        addEdge(1, 3);
        addEdge(1, 5);
        addEdge(2, 5);
        addEdge(2, 6);
        addEdge(3, 4);
        addEdge(3, 5);
        addEdge(3, 7);
        addEdge(4, 10);
        addEdge(5, 2);
        addEdge(5, 6);
        addEdge(5, 9);
        addEdge(6, 1);
        addEdge(7, 8);
        addEdge(7, 11);
        addEdge(8, 4);
        addEdge(11, 1);

        int startNode = 1;

        // Menjalankan DFS dan BFS
        List<Integer> dfsResult = dfs(startNode);
        List<Integer> bfsResult = bfs(startNode);

        // Menampilkan hasil DFS dan BFS
        System.out.println("DFS dari node " + startNode + ": " + dfsResult);
        System.out.println("BFS dari node " + startNode + ": " + bfsResult);
    }
}
