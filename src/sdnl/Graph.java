/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdnl;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ACER
 */
public class Graph {

    private int vertices;
    private int[][] adjacencyMatrix;
    private int vertexCount;
    private Vertex[] vertexList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
        this.vertexList = new Vertex[vertices];
        this.vertexCount = 0;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getVertices() {
        return vertices;
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
            adjacencyMatrix[source][destination] = 1;
            adjacencyMatrix[destination][source] = 1; //mengasumsikan sebagai graph tidak berarah

        } else {
            System.out.println("Invalid vertex index");
        }
    }

    public void removeEdge(int source, int destination) {
        if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
            adjacencyMatrix[source][destination] = 0;
            adjacencyMatrix[destination][source] = 0;

            // adjacencyMatrix[destination][source] = 0;
        } else {
            System.out.println("Invalid vertex index");
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void addVertex(String label) {
        if (vertexCount < vertices) {
            vertexList[vertexCount++] = new Vertex(label);

        } else {
            System.out.println("Graph Penuh, tidak bisa menambah lagi");
        }

    }

    public void displayVertex(int vertexIndex) {
        if (vertexIndex < vertexCount) {
            System.out.println("Vertex label " + vertexList[vertexIndex].label);

        } else {
            System.out.println("Invalid Index");

        }

    }

    public void displayMatrix() {
        System.out.print("  ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + " ");
        }
        System.out.println();
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void tampilMatrik() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void DFS(int startIndex) {
        Vertex startVertex = vertexList[startIndex];
        startVertex.visited = true;
        System.out.print(startVertex.label + " ");

        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[startIndex][i] == 1 && !vertexList[i].visited) {
                DFS(i);
            }

        }

    }

    public void dfs() {
        for (int i = 0; i < vertexCount; i++) {
            if (!vertexList[i].visited) {
                DFS(i);

            }
        }

        resetVisited();
    }

    private void BFS(int startIndex) {
        Queue<Integer> queue = new LinkedList<>();
        Vertex startVertex = vertexList[startIndex];
        startVertex.visited = true;
        System.out.print(startVertex.label + " ");
        queue.add(startIndex);

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();

            for (int i = 0; i < vertexCount; i++) {
                if (adjacencyMatrix[currentIndex][i] == 1 && !vertexList[i].visited) {
                    System.out.print(vertexList[i].label + " ");
                    vertexList[i].visited = true;

                    queue.add(i);
                }

            }
        }

    }

    public void bfs() {
        for (int i = 0; i < vertexCount; i++) {
            if (!vertexList[i].visited) {
                BFS(i);
            }
        }
        resetVisited();
    }

    
    
    private void resetVisited() {
        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].visited = false;

        }

    }

    

            }
        
    
