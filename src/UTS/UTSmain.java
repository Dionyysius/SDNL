/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

import sdnl.*;

/**
 *
 * @author ACER
 */
public class UTSmain {
    public static void main(String[] args) {
        Tree t = new Tree();
        int[] angka = {23,19,45,5,21,35,65,8,33,42};
        
        for (int i = 0; i < angka.length; i++) {
           t.Insert(angka[i]); 
        }
        t.BreathFirstSearch();
        System.out.println("");
        System.out.println("37 : "+t.sesuatu(37));
        System.out.println("19 : "+t.sesuatu(19));
        System.out.println("45 : "+t.sesuatu(45));
        
         System.out.println("50 : "+t.sesuatu(50));
         System.out.println("44 : "+t.sesuatu(44));
         
        
     
        
        
    }
    
}
