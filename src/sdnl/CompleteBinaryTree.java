package sdnl;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public CompleteBinaryTree() {
    }

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            insertRec(root, data);
        }
    }

    private void insertRec(TreeNode root, int data) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.getLeftChild() == null) {
                temp.setLeftChild(new TreeNode(data));
                break;
            } else {
                queue.add(temp.getLeftChild());
            }

            if (temp.getRightChild() == null) {
                temp.setRightChild(new TreeNode(data));
                break;
            } else {
                queue.add(temp.getRightChild());
            }
        }
    }

    public void breathFirstSearch() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.getiData() + " ");

            if (temp.getLeftChild() != null) {
                queue.add(temp.getLeftChild());
            }

            if (temp.getRightChild() != null) {
                queue.add(temp.getRightChild());
            }
        }
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        tree.breathFirstSearch();
    }
}
