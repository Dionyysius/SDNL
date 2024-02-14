/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author ACER
 */
public class TopologicalSort {

    public TopologicalSort() {
    }
    

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination) {
            adjList[source].addFirst(destination);
        }

        public void topologicalSorting() {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            //visit from each node if not already visited
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }
            System.out.println("Topological Sort: ");
            int size = stack.size();
            for (int i = 0; i <size ; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        public void topologicalSortUtil(int start, boolean[] visited, Stack<Integer> stack) {
            visited[start] = true;
            for (int i = 0; i < adjList[start].size(); i++) {
                int vertex = adjList[start].get(i);
                if (!visited[vertex])
                    topologicalSortUtil(vertex, visited, stack);
            }
            stack.push(start);
        }
        public void tampilMatrik() {
    int[][] adjacencyMatrix = new int[vertices][vertices];

    // Menginisialisasi matriks ketetanggaan
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            adjacencyMatrix[i][j] = 0;
        }
    }

    // Mengisi matriks ketetanggaan berdasarkan representasi daftar terkait
    for (int i = 0; i < vertices; i++) {
        for (int j : adjList [i]) {
            adjacencyMatrix[i][j] = 1;
        }
    }

    // Menampilkan matriks ketetanggaan
    System.out.println("Adjacency Matrix: ");
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            System.out.print(adjacencyMatrix[i][j] + " ");
        }
        System.out.println();
    }
}
  public void printGraph() {
    int[][] adjacencyMatrix = new int[vertices][vertices];

    for (int i = 0; i < vertices; i++) {
        for (int j : adjList[i]) {
            adjacencyMatrix[i][j] = 1;
        }
    }

    System.out.println("Adjacency Matrix: ");
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            System.out.print(adjacencyMatrix[i][j] + " ");
        }
        System.out.println();
    }
}

    }

    public static void main(String[] args) {
        int vertices = 7;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 5);
        graph.addEgde(1, 3);
        graph.addEgde(1, 4);
        graph.addEgde(2, 3);
        graph.addEgde(3, 4);
        graph.addEgde(4, 6);
        graph.printGraph();
        graph.tampilMatrik();
        graph.topologicalSorting();
    }
}