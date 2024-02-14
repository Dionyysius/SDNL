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
public class TreeNode {
     int iData;
     TreeNode LeftChild;
     TreeNode RightChild;

    public TreeNode(int iData) {
        this.iData = iData;
        this.LeftChild = null;
        this.RightChild = null;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public TreeNode getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(TreeNode LeftChild) {
        this.LeftChild = LeftChild;
    }

    public TreeNode getRightChild() {
        return RightChild;
    }

    public void setRightChild(TreeNode RightChild) {
        this.RightChild = RightChild;
    }
     
     

    
     
     
     
    
}
