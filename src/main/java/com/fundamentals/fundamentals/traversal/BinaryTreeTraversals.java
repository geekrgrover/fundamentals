package com.fundamentals.fundamentals.traversal;

public class BinaryTreeTraversals {
    
    public static void main(String[] args) {
        Node binaryTree = new Node(10, new Node(15, null, null), new Node(20, null, null));
        binaryTree.getLeftNode().setLeftNode(new Node(25, null, null));
        preOrderTraversal(binaryTree);
        postOrderTraversal(binaryTree);
        inOrderTraversal(binaryTree);
        
    }
    
    
    public static void inOrderTraversal(Node root) {
        System.out.println("\nIn Order Begins");
        if (root != null) {
            inOrderTraversal(root.getLeftNode());
        }
        System.out.print(root != null ? "" + root.getKey() + "" : "Leaf Node");
        if (root != null) {
            inOrderTraversal(root.getRightNode());
        }
        System.out.println("\nIn Order Ends");
        
    }
    
    public static void preOrderTraversal(Node root) {
        System.out.println("\nPre Order Begins");
        System.out.print(root != null ? "" + root.getKey() + "" : "Leaf Node");
        if (root != null) {
            
            preOrderTraversal(root.getRightNode());
            preOrderTraversal(root.getLeftNode());
        }
        System.out.println("\npre Order Ends");
    }
    
    public static void postOrderTraversal(Node root) {
        System.out.println("\nPost Order Begins");
        if (root != null) {
            postOrderTraversal(root.getLeftNode());
            postOrderTraversal(root.getRightNode());
        }
        System.out.print(root != null ? "" + root.getKey() + "" : "Leaf Node");
        System.out.println("\nPost Order Ends");
    }
    
}

class Node {
    int key;
    
    Node leftNode, rightNode;
    
    public Node(int id) {
        key = id;
        leftNode = rightNode = null;
        
    }
    
    public Node(int id, Node leftNode, Node rightNode) {
        this.key = id;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }
    
    
    public Node getLeftNode() {
        return leftNode;
    }
    
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
    
    public Node getRightNode() {
        return rightNode;
    }
    
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
    
    public int getKey() {
        return key;
    }
    
    public void setKey(int key) {
        this.key = key;
    }
    
}

class BinaryTree {

}