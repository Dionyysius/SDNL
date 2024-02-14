/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UTS;

/**
 *
 * @author ACER
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tree t = new Tree();
        int[] angka={40,30,50,25,35,45,60,15,28,55,70};
        
        for (int i = 0; i < angka.length; i++) {
            t.Insert(angka[i]);
            
        }
        System.out.println("");
        t.BreathFirstSearch();
        System.out.println("");
        t.inOrder(t.getRoot());
        System.out.println("");
        t.preOrder(t.getRoot());
        System.out.println("");
        t.postOrder(t.getRoot());
    }
    
}
