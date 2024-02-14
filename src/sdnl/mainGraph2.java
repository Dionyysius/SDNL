/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdnl;

/**
 *
 * @author ACER
 */
public class mainGraph2 {

    public static void main(String[] args) {
        Graph theGraph = new Graph(9);
        theGraph.addVertex("A"); // 0
        theGraph.addVertex("B"); // 1
        theGraph.addVertex("C"); // 2
        theGraph.addVertex("D"); // 3
        theGraph.addVertex("E"); // 4
        theGraph.addVertex("F"); // 5
        theGraph.addVertex("G"); // 6
        theGraph.addVertex("H"); // 7
        theGraph.addVertex("I"); // 8

        System.out.println("Daftar Vertex :");

        for (int i = 0; i < theGraph.getVertices(); i++) {
            theGraph.displayVertex(i);
        }
        theGraph.addEdge(0, 8);//AI
        theGraph.addEdge(0, 5);//AF
        theGraph.addEdge(0, 1);//AB
        theGraph.addEdge(1, 2);//BC
        theGraph.addEdge(1, 4);//BE
        theGraph.addEdge(2, 3);//CD
        theGraph.addEdge(2, 4);//CE
        theGraph.addEdge(3, 7);//DH
        theGraph.addEdge(3, 6);//DG
        theGraph.addEdge(4, 6);//EG
        theGraph.addEdge(6, 5);//GF

        System.out.println("Matrix Adjacency");
        theGraph.tampilMatrik(); 
        System.out.print("DFS : ");theGraph.dfs();
        
         System.out.println("");
         System.out.print("BFS : ");theGraph.bfs();
       
    }
}
