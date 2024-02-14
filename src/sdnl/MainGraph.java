/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sdnl;

/**
 *
 * @author ACER
 */
public class MainGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph theGraph = new Graph(8);
        theGraph.addVertex("A"); // 0
        theGraph.addVertex("B"); // 1
        theGraph.addVertex("C"); // 2
        theGraph.addVertex("D"); // 3
        theGraph.addVertex("E"); // 4
        theGraph.addVertex("F");
        theGraph.addVertex("G");
         theGraph.addVertex("H");

        System.out.println("Daftar Vertex : ");
        for (int i = 0; i < theGraph.getVertexCount(); i++) {
            theGraph.displayVertex(i);
        }

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        theGraph.addEdge(0, 7); //AH
        theGraph.addEdge(5, 6); //GH
        theGraph.addEdge(1, 6);

        System.out.println("Matriks adjacency");
        theGraph.tampilMatrik();
        
        
//         Graph thegraph = new Graph();
//        thegraph.addVertex("A"); // 0
//        thegraph.addVertex("B"); // 1
//        thegraph.addVertex("C"); // 2
//        thegraph.addVertex("D"); // 3
//        thegraph.addVertex("E"); // 4
//
//        System.out.println("Daftar Vertex : ");
//        for (int i = 0; i < thegraph.getVertexCount(); i++) {
//            thegraph.displayVertex(i);
//        }
//
//        thegraph.addEdge(0, 1); // AB
//        thegraph.addEdge(1, 2); // BC
//        thegraph.addEdge(0, 3); // AD
//        thegraph.addEdge(3, 4); // DE
//
//        System.out.println("Matriks adjacency");
//        theGraph.tampilMatrik();
    }
    
}
