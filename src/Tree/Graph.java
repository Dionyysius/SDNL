/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author ACER
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int maxVerts;
    private int nVerts;
    private Vertex[] vertexList;
    private int[][] adjMatrix;

    public Graph() {
        this.maxVerts = 20;
        this.nVerts = 0;
        vertexList = new Vertex[maxVerts];
        adjMatrix = new int[maxVerts][maxVerts];
        for (int i = 0; i < maxVerts; i++) {
            for (int j = 0; j < maxVerts; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }
    
    public Graph(int maxVerts) {
        this.maxVerts = maxVerts;
        this.nVerts = 0;
        vertexList = new Vertex[maxVerts];
        adjMatrix = new int[maxVerts][maxVerts];
        for (int i = 0; i < maxVerts; i++) {
            for (int j = 0; j < maxVerts; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(String label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    
    public void addArrowedEdge(int start, int end) {
        adjMatrix[start][end] = 1; 
    }
    
    public void addArrowedEdge(int start, int end, int weight) {
        adjMatrix[start][end] = weight; 
    }

    public String displayVertex(int v) {
        return vertexList[v].getLabel();
    }

    public void tampilMatrik() {
        System.out.print(" ");
        for (int i = 0; i < vertexList.length; i++) {
            if (vertexList[i] != null) {
                System.out.printf("%-3s", vertexList[i].getLabel()+" ");
            }
        }
        System.out.println("");
        for (int i = 0; i < nVerts; i++) {
            System.out.printf("%-3s",vertexList[i].getLabel()+" ");
            for (int j = 0; j < nVerts; j++) {
                System.out.printf("%-3s",adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getnVerts() {
        return nVerts;
    }
    
    public void bfs (){
        int kunjungi = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(kunjungi);
        while (!queue.isEmpty()) {            
            int bantu = queue.poll();
            if (!vertexList[bantu].isVisited()) {
                System.out.print(vertexList[bantu].getLabel()+" ");
                vertexList[bantu].setVisited(true);
            }
            for (int i = 0; i < nVerts; i++) {
                if (adjMatrix[bantu][i] >= 1) {
                    if (!vertexList[i].isVisited()) {
                        queue.add(i);
                    }
                }
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].setVisited(false);
        }
    }
    
    public void dfs(){
        int kunjungi = 0;
        int bantu;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(kunjungi);
        
        while (!stack.isEmpty()) {            
            bantu = stack.pop();
            if (!vertexList[bantu].isVisited()) {
                System.out.print(vertexList[bantu].getLabel()+" ");
                vertexList[bantu].setVisited(true);
            }
            for (int i = nVerts; i >= 0; i--) {
                if (adjMatrix[bantu][i] == 1) {
                    if (!vertexList[i].isVisited()) {
                        stack.push(i);
                    }
                }
        }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].setVisited(false);
        }
    }
    
    public void topologi() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[maxVerts];

        topologi(0, visited, stack);

        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(vertexList[stack.pop()].getLabel() + " ");
        }
    }

    private void topologi(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int i = 0; i < nVerts; i++) {
            if (adjMatrix[v][i] == 1 && !visited[i]) {
                topologi(i, visited, stack);
            }
        }

        stack.push(v);
    }
    
    public void shortestPath(int startVertex) {
        // Array untuk menyimpan jarak terpendek dari startVertex ke setiap vertex
        int[] distance = new int[maxVerts];
        Arrays.fill(distance, Integer.MAX_VALUE); // Mengisi awal dengan nilai tak terhingga
        distance[startVertex] = 0;

        // Array untuk menyimpan informasi apakah vertex sudah dikunjungi atau belum
        boolean[] visited = new boolean[maxVerts];

        // Proses Dijkstra
        for (int count = 0; count < nVerts; count++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < nVerts; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && distance[u] != Integer.MAX_VALUE
                        && distance[u] + adjMatrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + adjMatrix[u][v];
                }
            }
        }

        // Menampilkan hasil shortest path
        System.out.println("Shortest path dari vertex " + vertexList[startVertex].getLabel() + ":");
        for (int i = 0; i < nVerts; i++) {
            System.out.println(
                    "To " + vertexList[i].getLabel() + ": " + (distance[i] == Integer.MAX_VALUE ? "I N F I N I T Y" : distance[i]));
        }
    }

    private int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int v = 0; v < nVerts; v++) {
            if (!visited[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        
        return minIndex;
    }
    
}