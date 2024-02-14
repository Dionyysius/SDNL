/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectSDNL;

/**
 *
 * @author ACER
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class cobaKRuskal {

    /**
     * @param args the command line arguments
     */
   


    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge); // Add to total edges
        }

        public void efficientRoute() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

            // Add all the edges to priority queue, sort the edges on weights
            for (int i = 0; i < allEdges.size(); i++) {
                pq.add(allEdges.get(i));
            }

            // Create a parent []
            int[] parent = new int[vertices];

            // Make set
            makeSet(parent);

            ArrayList<Edge> mst = new ArrayList<>();

            // Process vertices - 1 edges
            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                // Check if adding this edge creates a cycle
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if (x_set == y_set) {
                    // Ignore, will create cycle
                } else {
                    // Add it to our final result
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
            // Print MST (efficient route)
            System.out.println("Efficient Route: ");
            printGraph(mst);
        }

        public void makeSet(int[] parent) {
            // Make set- creating a new element with a parent pointer to itself.
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex)
                return find(parent, parent[vertex]);
            return vertex;
        }

        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            // Make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList) {
            int totalWeight = 0;
            for (int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
                totalWeight += edge.weight;
            }
            System.out.println("Total Weight of Efficient Route: " + totalWeight);
        }
    }

    public static void main(String[] args) {
        int vertices = 10; // Change this based on the number of vertices in your graph
        Graph graph = new Graph(vertices);

        // Adding edges to the graph
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 12);
        graph.addEdge(0, 4, 15);
        graph.addEdge(1, 5, 3);
        graph.addEdge(2, 6, 7);
        graph.addEdge(3, 6, 8);
        graph.addEdge(4, 9, 10);
        graph.addEdge(5, 7, 2);
        graph.addEdge(6, 7, 5);
        graph.addEdge(6, 8, 4);
        graph.addEdge(6, 9, 5);
        graph.addEdge(8, 9, 3);
        
        
        

        // Find the most efficient route
        graph.efficientRoute();
    }
}

    

