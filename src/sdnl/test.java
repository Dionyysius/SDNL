/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sdnl;

/**
 *
 * @author ACER
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Tree t = new Tree();
        t.Insert(60);
        t.Insert(55);
        t.Insert(100);
        t.Insert(107);
        t.Insert(67);
        t.Insert(105);
        t.Insert(57);
        t.Insert(45);
        t.Insert(59);
        t.Insert(106);
        t.Insert(43);
        t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(100);
        System.out.println("Find Max : ");System.out.println(t.findMax());
        System.out.println("Find min : ");System.out.println( t.findMin());
        
         t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(55);
         t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(60);
         t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(57);
         t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(67);
         t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(105);
         t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(106);
         t.inOrder(t.getRoot());
        System.out.println("");
        t.Delete(59);
         t.inOrder(t.getRoot());
        System.out.println("");
        
        
    }
    
}
