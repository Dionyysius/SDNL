/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectSDNL;

import Tree.*;

/**
 *
 * @author ACER
 */
public class main11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              Graph graph = new Graph();
        graph.addVertex("A"); // 0
        graph.addVertex("B"); // 1
        graph.addVertex("C"); // 2
        graph.addVertex("D"); // 3
        graph.addVertex("E"); // 4
        graph.addVertex("F"); // 5
        
        System.out.println("Daftar Vertex : ");
        for (int i=0;i< graph.getnVerts();i++)
            System.out.print(graph.displayVertex(i)+ " ");

               System.out.println("");
        System.out.println("");
        
        System.out.println("Jarak dari A ke B adalah 50");
        graph.addArrowedEdge(0, 1, 50);
        System.out.println("Jarak dari A ke C adalah 30");
        graph.addArrowedEdge(0, 2, 30);
        System.out.println("Jarak dari A ke D adalah 100");
        graph.addArrowedEdge(0, 3, 100);
        System.out.println("Jarak dari A ke F adalah 10");
        graph.addArrowedEdge(0, 5, 10);
        System.out.println("Jarak dari B ke C adalah 5");
        graph.addArrowedEdge(1, 2, 5);
        System.out.println("Jarak dari C ke B adalah 5");
        graph.addArrowedEdge(2, 1, 5);
        System.out.println("Jarak dari D ke B adalah 20");
        graph.addArrowedEdge(3, 1, 20);
        System.out.println("Jarak dari D ke C adalah 50");
        graph.addArrowedEdge(3, 2, 50);
        System.out.println("Jarak dari E ke C adalah 15");
        graph.addArrowedEdge(4, 3, 15);
        System.out.println("Jarak dari E ke F adalah 15");
        graph.addArrowedEdge(4, 5, 15);
        System.out.println("Jarak dari F ke D adalah 10");
        graph.addArrowedEdge(5, 3, 10);
        
        System.out.println("");
        
        graph.shortestPath(0);

    }
    
}
