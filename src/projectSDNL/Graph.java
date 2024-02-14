/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectSDNL;

/**
 *
 * @author ACER
 */

import Tree.*;
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
     public void kruskalMST() {
        Edge[] result = new Edge[nVerts - 1];
        int index = 0;

        // Mengurutkan semua edge berdasarkan bobotnya
        Edge[] edges = getAllEdges();

        Arrays.sort(edges);

        // Membuat subset untuk setiap vertex
        Subset[] subsets = new Subset[nVerts];
        for (int i = 0; i < nVerts; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i = 0;
        while (index < nVerts - 1) {
            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);

            if (x != y) {
                result[index++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Edges in MST by Kruskal's Algorithm:");
        for (i = 0; i < index; i++) {
            System.out.println(
                    vertexList[result[i].source].getLabel() + " - " + vertexList[result[i].destination].getLabel() +
                            "  Weight: " + result[i].weight);
        }
    }

    // Method untuk mencari semua edge dalam graf
    private Edge[] getAllEdges() {
        Edge[] edges = new Edge[nVerts * nVerts];
        int edgeCount = 0;

        for (int i = 0; i < nVerts; i++) {
            for (int j = 0; j < nVerts; j++) {
                if (adjMatrix[i][j] != 0) {
                    edges[edgeCount++] = new Edge(i, j, adjMatrix[i][j]);
                }
            }
        }

        Edge[] result = new Edge[edgeCount];
        System.arraycopy(edges, 0, result, 0, edgeCount);

        return result;
    }

    // Method untuk mencari representatif dari suatu set
    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Method untuk menggabungkan dua set
    private void union(Subset[] subsets, int x, int y) {
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    // Kelas untuk merepresentasikan edge
    class Edge implements Comparable<Edge> {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Kelas untuk merepresentasikan subset dari himpunan vertex
    class Subset {
        int parent, rank;
    }
     public void shortestPathBetweenVertices(int startVertex, int endVertex) {
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

        // Menampilkan hasil shortest path antara kedua vertex
        System.out.println("Shortest path dari " + vertexList[startVertex].getLabel() +
                " ke " + vertexList[endVertex].getLabel() + " adalah: " +
                (distance[endVertex] == Integer.MAX_VALUE ? "Tidak terhubung" : distance[endVertex]));
    }
     public void shortestPathByVertexNames(String startVertexLabel, String endVertexLabel) {
        int startIndex = -1;
        int endIndex = -1;

        // Mencari indeks dari startVertexLabel dan endVertexLabel
        for (int i = 0; i < nVerts; i++) {
            if (vertexList[i].getLabel().equals(startVertexLabel)) {
                startIndex = i;
            }
            if (vertexList[i].getLabel().equals(endVertexLabel)) {
                endIndex = i;
            }
            if (startIndex != -1 && endIndex != -1) {
                break;
            }
        }

        // Memastikan kedua vertex ditemukan sebelum memanggil shortestPathBetweenVertices
        if (startIndex != -1 && endIndex != -1) {
            shortestPathBetweenVertices(startIndex, endIndex);
        } else {
            System.out.println("Vertex tidak ditemukan.");
        }
    }
}
