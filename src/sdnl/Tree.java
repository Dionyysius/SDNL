/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdnl;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ACER
 */

public class Tree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public Tree() {
    }
    
    

    public void Insert(int data) {
        TreeNode baru = new TreeNode(data);
        
        if (root == null) {
            root=baru;
            
        }else {
            TreeNode bantu = root;
            while(true){
            if (baru.getiData()<bantu.getiData()) {
                if (bantu.getLeftChild()==null) {
                     bantu.setLeftChild(baru);
                      return;
                } else {
                    bantu=bantu.getLeftChild();
                }
               
                
            }else{
                  if (bantu.getRightChild()==null) {
                     bantu.setRightChild(baru);
                     return;
                } else {
                    bantu=bantu.getRightChild();
                }
                
            
            }
            }
        }
    }

    public boolean search(int key){
        TreeNode temp= this.root;
        while(temp!=null){
            if (temp.getiData()<key) {
                temp=temp.getRightChild();
                
            }else if (temp.getiData()>key) {
                temp=temp.getLeftChild();
                
            }else if (temp.getiData()==key) {
                return true;
                
            }
        
        }
      
        return false;
 }
    public void BreathFirstSearchtes(){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            System.out.println(temp.getiData()+" ");
            
            if (temp.getLeftChild()!=null ) {
                q.add(temp.getLeftChild());
                
            }if ( temp.getRightChild()!=null) {
                q.add(temp.getRightChild());
            }
        }
    
    
    
    }
    public void BreathFirstSearch(){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            System.out.print(temp.getiData()+" ");
            
            if (temp.getLeftChild()!=null && temp.getRightChild()!=null) {
                q.add(temp.getLeftChild());
                q.add(temp.getRightChild());
            }else if (temp.getLeftChild()!=null) {
                 q.add(temp.getLeftChild());
            }else if(temp.getRightChild()!=null){
                q.add(temp.getRightChild());
            }
        }
    
    
    
    }
    public void preOrder(TreeNode localRoot){
        if (localRoot!=null) {
            System.out.print(localRoot.getiData()+" ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
                    
            
        }
    
    
    }
    public void inOrder(TreeNode localRoot){
        if (localRoot!=null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getiData()+" ");
            inOrder(localRoot.getRightChild());
            
        }
    
    
    
    }
    public void postOrder(TreeNode localRoot){
        if (localRoot!=null) {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot.getiData()+" ");
            
        }
    
    
    }
 
 public TreeNode delete(int key) {
        TreeNode parent = getRoot();
        TreeNode temp = getRoot();

        while (temp != null) {
            if (key < temp.getiData()) {
                parent = temp;
                temp = temp.getLeftChild();
            } else if (key > temp.getiData()) {
                parent = temp;
                temp = temp.getRightChild();
            } else {
                if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                    if (key < parent.getiData()) {
                        parent.setLeftChild(null);
                        
                    } else if(key > parent.getiData()) {
                        parent.setRightChild(null);
                    }else{
                    root=null;
                    }
                } else if (temp.getLeftChild() == null && temp.getRightChild() != null) {
                    //kondisi 1 atau 2
                    if (key < parent.getiData()) {
                        parent.setLeftChild(temp.getRightChild());
                    } else if(key>parent.getiData()) {
                        parent.setRightChild(temp.getRightChild());
                    }else{
                        parent=temp.getRightChild();
                        root=temp.getRightChild();
                    
                    }
                }//kondisi 3 , kiri null dan kanan kosong
                else if (temp.getLeftChild() != null && temp.getRightChild() == null) {
                    if (key < parent.getiData()) {
                        //kondisi 4 punya anak kiri dari anak kiri
                        parent.setLeftChild(temp.getLeftChild());
                    } else if(key>parent.getiData()) {
                        //kondisi 4 punya anak kanan dari anak kiri
                        parent.setRightChild(temp.getLeftChild());
                    }else{
                        parent=temp.getLeftChild();
                        root=temp.getLeftChild();
                    }
                }
                return temp;
            }
        }
        return null;
    }
  public Boolean Delete(int key) {
        TreeNode parent = getRoot();
        TreeNode temp = getRoot();

        while (temp != null) {
            if (key < temp.getiData()) {
                parent = temp;
                temp = temp.getLeftChild();
            } else if (key > temp.getiData()) {
                parent = temp;
                temp = temp.getRightChild();
            } else {
                if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                    if (key < parent.getiData()) {
                        parent.setLeftChild(null);
                        
                    } else if(key > parent.getiData()) {
                        parent.setRightChild(null);
                    }else{
                    root=null;
                    }
                } else if (temp.getLeftChild() == null && temp.getRightChild() != null) {
                    //kondisi 1 atau 2
                    if (key < parent.getiData()) {
                        parent.setLeftChild(temp.getRightChild());
                    } else if(key>parent.getiData()) {
                        parent.setRightChild(temp.getRightChild());
                    }else{
                        parent=temp.getRightChild();
                        root=temp.getRightChild();
                    
                    }
                }//kondisi 3 , kiri null dan kanan kosong
                else if (temp.getLeftChild() != null && temp.getRightChild() == null) {
                    if (key < parent.getiData()) {
                        //kondisi 4 punya anak kiri dari anak kiri
                        parent.setLeftChild(temp.getLeftChild());
                    } else if(key>parent.getiData()) {
                        //kondisi 4 punya anak kanan dari anak kiri
                        parent.setRightChild(temp.getLeftChild());
                    }else{
                        parent=temp.getLeftChild();
                        root=temp.getLeftChild();
                    }
                }
                else{
                    //kondisi 2 anak
                    TreeNode successor = getSuccessor(temp);
                    if (temp==root) {
                        root=successor;
                        
                    }else if (key < parent.getiData()) {
                        parent.setLeftChild(successor);
                    }else{
                        parent.setRightChild(successor);
                    
                    
                    }
                    successor.setLeftChild(temp.getLeftChild());
                
                
                
                }
                return true;
            }
        }
        return false;
    }
// public TreeNode coba(int key) {
//        TreeNode parent = getRoot();
//        TreeNode temp = getRoot();
//
//        while (temp != null) {
//            if (key < temp.getiData()) {
//                parent = temp;
//                temp = temp.getLeftChild();
//            } else if (key > temp.getiData()) {
//                parent = temp;
//                temp = temp.getRightChild();
//            } else {
//                if (temp.getLeftChild() == null && temp.getRightChild() == null) {
//                    if (key==parent.getiData()) {
//                        root=null;
//                        
//                    }else if (key < parent.getiData()) {
//                        parent.setLeftChild(null);
//                        return parent.getRightChild();
//                    } else {
//                        parent.setRightChild(null);
//                        return parent.getLeftChild();
//                    }
//               } else if (temp.getLeftChild() == null && temp.getRightChild() != null) {
//                   //kondisi 1 atau 2 
//                    if (key==parent.getiData()) {
//                        setRoot(parent.getLeftChild());
//                    }else if (key < parent.getiData()) {
//                      parent.setLeftChild(temp.getRightChild());
//                    return parent.getLeftChild();
//                    } else {
//                        parent.setRightChild(temp.getRightChild());
//                        return parent.getLeftChild();
//                  }
//               }//kondisi 3 , kiri null dan kanan kosong
//               else if (temp.getLeftChild() != null && temp.getRightChild() == null) {
//                    if (key==parent.getiData()) {
//                        setRoot(parent.getRightChild());
//                        
//                    }else
//                  if (key < parent.getiData()) {
//                       //kondisi 4 punya anak kiri dari anak kiri
//                       parent.setLeftChild(temp.getLeftChild());
//                        return parent.getRightChild();
//                    } else {
//                        //kondisi 4 punya anak kanan dari anak kiri
//                        parent.setRightChild(temp.getLeftChild());
//                        return parent.getRightChild();
//                    }
//                }
//                return parent;
//            }
//        }
//        return null;
//    }
 
 
 // Metode untuk mendapatkan penerus dari sebuah node
private TreeNode getSuccessor(TreeNode node) {
    TreeNode successorParent = node;
    TreeNode successor = node;
    TreeNode temp = node.getRightChild();

    while (temp != null) {
        successorParent = successor;
        successor = temp;
        temp = temp.getLeftChild();
    }

    // Jika penerus bukan anak langsung dari node yang dihapus,
    // maka hubungkan penerus dengan anak kanan
    if (successor != node.getRightChild()) {
        successorParent.setLeftChild(successor.getRightChild());
        successor.setRightChild(node.getRightChild());
    }

    return successor;
}
private TreeNode getPredecessor(TreeNode node) {
    TreeNode predecessorParent = node;
    TreeNode predecessor = node;
    TreeNode temp = node.getLeftChild();

    while (temp != null) {
        predecessorParent = predecessor;
        predecessor = temp;
        temp = temp.getRightChild();
    }

    // Jika penerus bukan anak langsung dari node yang dihapus,
    // maka hubungkan penerus dengan anak kiri
    if (predecessor != node.getLeftChild()) {
        predecessorParent.setRightChild(predecessor.getLeftChild());
        predecessor.setLeftChild(node.getLeftChild());
    }

    return predecessor;
}

 public Boolean DeletePro(int key) {
        TreeNode parent = getRoot();
        TreeNode temp = getRoot();

        while (temp != null) {
            if (key < temp.getiData()) {
                parent = temp;
                temp = temp.getLeftChild();
            } else if (key > temp.getiData()) {
                parent = temp;
                temp = temp.getRightChild();
            } else {
                if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                    if (key < parent.getiData()) {
                        parent.setLeftChild(null);
                        
                    } else if(key > parent.getiData()) {
                        parent.setRightChild(null);
                    }else{
                    root=null;
                    }
                } else if (temp.getLeftChild() == null && temp.getRightChild() != null) {
                    //kondisi 1 atau 2
                    if (key < parent.getiData()) {
                        parent.setLeftChild(temp.getRightChild());
                    } else if(key>parent.getiData()) {
                        parent.setRightChild(temp.getRightChild());
                    }else{
                        parent=temp.getRightChild();
                        root=temp.getRightChild();
                    
                    }
                }//kondisi 3 , kiri null dan kanan kosong
                else if (temp.getLeftChild() != null && temp.getRightChild() == null) {
                    if (key < parent.getiData()) {
                        //kondisi 4 punya anak kiri dari anak kiri
                        parent.setLeftChild(temp.getLeftChild());
                    } else if(key>parent.getiData()) {
                        //kondisi 4 punya anak kanan dari anak kiri
                        parent.setRightChild(temp.getLeftChild());
                    }else{
                        parent=temp.getLeftChild();
                        root=temp.getLeftChild();
                    }
                }
                else{
                    //kondisi 2 anak
                    TreeNode predecessor = getPredecessor(temp);
                    if (temp==root) {
                        root=predecessor;
                        
                    }else if (key > parent.getiData()) {
                        parent.setRightChild(predecessor);
                    }else{
                        parent.setLeftChild(predecessor);
                    
                    
                    }
                    predecessor.setRightChild(temp.getLeftChild());
                
                
                
                }
                return true;
            }
        }
        return false;
    }

public int findMin() {
    TreeNode current = root;
    while (current.getLeftChild() != null) {
        current = current.getLeftChild();
    }
    return current.getiData();
}

public int findMax() {
    TreeNode current = root;
    while (current.getRightChild() != null) {
        current = current.getRightChild();
    }
    return current.getiData();
}

public TreeNode findPredecessor(TreeNode node) {
    if (node == null) {
        return null;
    }
    if (node.getLeftChild() != null) {
        TreeNode current = node.getLeftChild();
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    } else {
        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor != node) {
            if (node.getiData() > ancestor.getiData()) {
                successor = ancestor;
                ancestor = ancestor.getRightChild();
            } else {
                ancestor = ancestor.getLeftChild();
            }
        }
        return successor;
    }
}


public int size(TreeNode node) {
    if (node == null) {
        return 0;
    }
    return 1 + size(node.getLeftChild()) + size(node.getRightChild());
}


public boolean isCompleteTree(TreeNode node, int index, int size) {
    if (node == null) {
        return true;
    }
    if (index >= size) {
        return false;
    }
    return isCompleteTree(node.getLeftChild(), 2 * index + 1, size) && isCompleteTree(node.getRightChild(), 2 * index + 2, size);
}
public int height(TreeNode node) {
    if (node == null) {
        return -1;
    }
    int leftHeight = height(node.getLeftChild());
    int rightHeight = height(node.getRightChild());
    return 1 + Math.max(leftHeight, rightHeight);
}


 
 
 
 
 }
    
    
    

