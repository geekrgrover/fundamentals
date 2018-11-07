package com.fundamentals.fundamentals.traversal;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    Node<T> root = null;
    
    @Override
    public Iterator<T> iterator() {
        return null;
    }
    
    public Node<T> insert(T data) {
        if (data == null) {
            return null;
        }
        
        return insert(root, data);
    }
    
    /**
     * Inserting in BTree
     *
     * @param node
     * @param data
     * @return
     */
    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<T>(data);
        }
        if (compare(null, node.data, data) == 0) {
            return node;
        }
        if (compare(null, node.data, data) > 0) {
            node.left = insert(node.left, data);
        } else if (compare(null, node.data, data) < 0) {
            node.right = insert(node.right, data);
        }
        return node;
    }
    
    /**
     * Seatch for data in BTree
     *
     * @param root
     * @param data
     * @return
     */
    public Node<T> search(Node<T> root, T data) {
        
        if (data == null) {
            return null;
        }
        
        if (root.data == data) {
            return root;
        } else if (compare(null, root.data, data) > 0) {
            root = root.left;
            search(root, data);
        } else if (compare(null, root.data, data) < 0) {
            root = root.right;
            search(root, data);
            
        }
        
        return null;
        
    }
    
    
    public void delete(T data) {
        root = delete(root, data);
        
    }
    
    private Node<T> delete(Node<T> root, T data) {
        
        if (root == null || data == null) {
            // return root;
            throw new RuntimeException("cant delete null");
        }
        //traverse and find the node to delete
        if (compare(null, data, root.data) < 0) {
            root.left = delete(root.left, data);
        } else if (compare(null, data, root.data) > 0) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //If the node to be deleted (already found when reaching here) has both left and right children, then find the smallest child in the right subtree and replace the root to be deleted with the value of that key. After that delete this small node
            else {
                Node<T> smallRightNode = retrieveSmallRightNode(root);
                root.data = smallRightNode.data;
                root.right = delete(smallRightNode, smallRightNode.data);
            }
            
        }
        return root;
    }
    
    private Node<T> retrieveSmallRightNode(Node<T> root) {
        Node<T> p = null;
        if (root == null)
            return null;
        if (root.right == null) {
            p = retrieveSmallRightNode(root.left);
        } else {
            p = retrieveSmallRightNode(root.right);
        }
        return p;
    }
    
    /**
     * Comparing whether data in 2 nodes are equal more or less
     *
     * @param comparator
     * @param a
     * @param b
     * @return
     */
    public int compare(Comparator<T> comparator, T a, T b) {
        if (comparator == null) {
            return a.compareTo(b);
        } else {
            return comparator.compare(a, b);
        }
    }
    
    /**
     * The node class
     *
     * @param <T>
     */
    private class Node<T> {
        Node<T> left, right;
        T data;
        
        public Node() {
            data = null;
            left = right = null;
        }
        
        public Node(T data) {
            this.data = data;
            left = right = null;
        }
        
        public Node(T dat, Node<T> l, Node<T> r) {
            left = l;
            right = r;
            data = dat;
        }
        
        public String toString() {
            return data.toString();
        }
        
    }
    
}
