/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sdnl;

/**
 *
 * @author ACER
 */
public class SDNL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tree t = new Tree();
        t.Insert(56);
        t.Insert(30);
        t.Insert(40);
        t.Insert(22);
        t.Insert(70);
        t.Insert(95);
        t.Insert(60);
        t.Insert(65);
        t.Insert(11);
        t.Insert(16);
        t.Insert(63);
        t.Insert(67);
        t.Insert(3);
        t.Insert(37);
        t.Insert(88);
        System.out.println("Modul");

        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());System.out.println("");
        System.out.print("BFS : ");
        t.BreathFirstSearch();
        System.out.println("");
        System.out.print("PreOrder : ");
        t.preOrder(t.getRoot());
        System.out.println("");
        System.out.print("Post Order : ");
        t.postOrder(t.getRoot());
        System.out.println("");
        System.out.println("Max : "+t.findMax());
        System.out.println("Min : "+t.findMin());
        
        System.out.println("Mencari Predecessor : "+t.findPredecessor(t.getRoot()).getiData());

        System.out.println("Height : "+t.height(t.getRoot()));
        System.out.println("compelete Tree : "+t.isCompleteTree(t.getRoot(), 0, t.height(t.getRoot())));
        System.out.println("Size : "+t.size(t.getRoot()));
        
        System.out.println("");
        Boolean hasil = t.Delete(100);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");
        hasil = t.Delete(63);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");
        hasil = t.Delete(65);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(60);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");
        hasil = t.Delete(95);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");
        hasil = t.Delete(88);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(67);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(70);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(56);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");
        hasil = t.Delete(22);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(16);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(11);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(3);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(30);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

        hasil = t.Delete(40);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");
        hasil = t.Delete(37);
        if (hasil == true) {
            System.out.println("Berhasil Dihapus");

        } else {
            System.out.println("Tidak berhasil dihapus");
        }
        System.out.print("InOrder : ");
        t.inOrder(t.getRoot());

        System.out.println("");

    }
}
