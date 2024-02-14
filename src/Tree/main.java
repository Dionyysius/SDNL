/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tree;

import sdnl.Graph;

/**
 *
 * @author ACER
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int vertices = 7;
        Graph graph = new Graph(vertices);
        TopologicalSort topo= new TopologicalSort();
        //j1 = 0
        //j2 = 1
        //j3 = 2
        //j4 = 3
        //j5 = 4
        //j6 = 5 
        //j7 = 6
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        System.out.println("Matriks adjacency");
        graph.printGraph();
        System.out.println("ToplogicalSort : ");
        
        
        
        
       
    }
    
}
