package com.fundamentals.fundamentals.simpleCodingPractice;

public class TreeOps {

    static int addNumbers(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Node n = new Node(10, "root", new Node(8, "left", null, null), new Node(12, "right", null, null));
        Node res = bSTSearch(12, n);
        System.out.println(res == null ? null : res.getKey());
        Node newNode = bSTInsert(11, n);
        System.out.println("New node Key " + newNode.getKey());
        Node newRecNode1 = bSTRecursiveInsert(13, n);
        Node newRecNode2 = bSTRecursiveInsert(6, n);
        System.out.println("New node rec :" + newRecNode1.getKey());
        System.out.println("New node rec :" + newRecNode2.getKey());
        int[] insAr = new int[]{2, 5, 4, 6, 7, 25, 14, 17};
        for (int i : insAr) {
            bSTRecursiveInsert(i, n);
            bSTInsert(i, n);
        }
        Node test = bSTSearch(25, n);
        System.out.println("Found this for 25 " + (test == null ? null : test.getKey()));
        Integer min = minimumElement(n);
        System.out.println("Minimum element :" + (min == null ? "null" : min.intValue()));

        Integer max = maximumElement(n);
        System.out.println("Maximum element :" + (max == null ? "null" : max.intValue()));

        minimumElementRecursion(n);
        maximumElementRecursion(n);
        System.out.println("Predecessor of 10 :"+ predecessor(n, n).getKey());
        System.out.println("Successor of 10 :"+ successor(n, n).getKey());

        Node newRoot = deleteNode(n, 12);
        System.out.println("New root after deleting 12: "+newRoot.getKey() );


    }


    public static Node bSTSearch(int k, Node root) {

        while (root != null) {
            if (root.getKey() == k) {
                System.out.println("found");
                return root;
            } else {
                if (root != null && root.getKey() > k) {
                    System.out.println("left");
                    root = root.getLeft();
                } else if (root != null && root.getKey() < k) {
                    System.out.println("right");
                    root = root.getRight();
                }
            }
        }
        return null;
    }


    public static Node bSTInsert(int key, Node root) {
        Node newNode = new Node(11, "New Node", null, null);
        Node previous = null;
        if (root == null) {
            root = newNode;
            return root;
        }
        while (root != null) {
            if (root.getKey() == key) {
                System.out.println("Key exists");
                return root;
            } else {
                if (root.getKey() < key) {
                    previous = root;
                    root = root.getRight();
                } else if (root.getKey() > key) {
                    previous = root;
                    root = root.getLeft();
                }
            }
        }
        root = newNode;
        if (root != null) {
            if (root.getKey() < previous.getKey()) {
                root.setRight(previous);
            } else {
                root.setLeft(previous);
            }
        }
        return root;
    }

    public static Node bSTRecursiveInsert(int key, Node root) {
        //System.out.println("Insert key :"+ key);
        return bSTRecursiveInsertHelper(key, root, null);
    }


    private static Node bSTRecursiveInsertHelper(int key, Node root, Node prev) {
        if (root == null) {
            root = new Node(key, "new node", null, null);
            ;
            System.out.println("inserted :" + root.getKey());
            if (prev.getKey() < key) {
                prev.setRight(root);
            } else {
                prev.setLeft(root);
            }
            return root;
        }
        if (root.getKey() < key) {
            prev = root;
            root = root.getRight();
            bSTRecursiveInsertHelper(key, root, prev);
        } else if (root.getKey() > key) {
            prev = root;
            root = root.getLeft();
            bSTRecursiveInsertHelper(key, root, prev);
        }
        return root;
    }

    public static Integer minimumElement(Node root) {
        if (root == null) {
            return null;
        }
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root.getKey();
    }

    public static Integer maximumElement(Node root) {
        if (root == null) {
            return null;
        }
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root.getKey();
    }

    public static void minimumElementRecursion(Node root) {
        if (root == null) { // Base 0
            System.out.println("min- recur: Root is null");
        }
        if (root.getLeft() == null) { // Base 1
            System.out.println("min- recur: min is " + root.getKey());
        } else { // recursion
            root = root.getLeft();
            minimumElementRecursion(root);
        }
    }

    public static void maximumElementRecursion(Node root) {
        if (root == null) { // Base 0
            System.out.println("Max- recur: Root is null");
        }
        if (root.getRight() == null) { // Base 1
            System.out.println("max- recur: max is " + root.getKey());
        } else { // recursion
            root = root.getRight();
            maximumElementRecursion(root);
        }
    }

    /**
     * Successor is the next biggest element of a node/ key in the tree
     **/
    public static Node successor(Node root, Node k) {
        if (root == null) {
            return root;
        }
        // if k has a right subtree, successor will be teh left most elemement (smallest element) in that
        if (k.getRight() != null) {
            Node curr = k.getRight();
            while (curr.getLeft() != null) {
                curr = curr.getLeft();
            }
            return curr;
        }
        // If K does not have a right subtree, then the successor woild be the first parent node to the right that has a left ancestor.
        // To find this out, we need to traverse frm the root and idenfify the last left turn made before reaching K
        else {
            Node ancenstor = null;
            Node curr = root;
            while (curr.getKey() != k.getKey()) {
                if (curr.getKey() < k.getKey()) {
                    curr = curr.getRight();
                } else {
                    ancenstor = curr;
                    curr = curr.getLeft();
                }
            }
            return ancenstor;
        }
    }

    /**
     * Predecessor the next smaller node/ key to a given node in the tree.
     **/
    public static Node predecessor(Node root, Node k) {
        if (root == null) {
            return root;
        }
        // The predecessor will be the largest value in the left substree, if there is a left subtree for the given node
        if (k.getLeft() != null) {
            Node curr = null;
            // finding largest value (right most) in the left subtree
            while (k.getRight() != null) {
                curr = curr.getRight();
            }
            return curr;
        }
        // If there is no left subtree present for K, then predecessor would be the left parent node that has a right ancestor
        // To find this out we need to travers from root to K and record the last right turn made before reaching K
        else {
            Node curr = root;
            Node ancestor = null;
            while (k.getKey() != curr.getKey()) {
                if (curr.getKey() < k.getKey()) {
                    ancestor = curr;
                    curr = curr.getRight();
                } else {
                    curr = curr.getLeft();
                }
            }
            return ancestor;
        }
    }
    public static Node deleteNode(Node root, int k) {
        if (root == null ) {
            return root;
        }
        Node curr = root;
        Node previous = null;
        while(curr.getKey() != k) { // find the node to be deleted in the tree
            if(curr.getKey() < k) {
                previous = curr;
                curr = curr.getRight();
            }
            else {
                previous = curr;
                curr = curr.getLeft();
            }
        }
        if(curr.getRight() == null && curr.getLeft() == null) { // leaf node
            System.out.println("deleting leaf node");
            if(previous == null ) { // single node tree or node to be deleted is the root node
                return null;
            }
            if (previous.getRight().getKey() == k)
            {
                curr.setRight(null);
            }
            else if(previous.getLeft().getKey() == k) {
                curr.setLeft(null);
            }
        } else if (curr.getRight() != null || curr.getLeft()!= null) { //node with one subtree
            System.out.println("deleting node with 1 subtrees");
            if(curr.getLeft()!= null) { // have a left subtree
                if(previous == null) { // the node to be deleted is root itself and root has left subtree
                    root = curr.getLeft();
                    return root;
                }
                else if (curr == previous.getLeft()) {
                    previous.setLeft(curr.getLeft());
                } else {
                    previous.setRight(curr.getLeft());
                }

            } else if(curr.getRight()!= null) {// have a right subtree
                if(previous == null) { // the node to be deleted is root itself and root has left subtree
                    root = curr.getRight();
                    return root;
                }
                else if(curr == previous.getLeft()) {
                    previous.setLeft(curr.getRight());
                } else {
                    previous.setRight(curr.getRight());
                }

            }

        } else if (curr.getRight()!= null && curr.getLeft()!= null) { // node has both left and right subtrees
            // 1. Find the success or or predecessor - One of these nodes have to replace the node to be deleted. Going with successor here
            System.out.println("deleting node with 2 subtrees");
            Node successor = curr.getRight(); // right subtree
            Node subprevious = curr;
            while(successor!= null) {
                if(successor.getLeft()!= null) {
                    subprevious = successor;
                    successor = successor.getLeft(); // left most element of right subtree
                }
            }
            curr.setKey(successor.getKey()); // Keep the node at its position and relace the key with the key of successor
            if(subprevious.getLeft() == successor) { // delete the successor after connecting any subtrees success has (possible right subtree ) with successor's parent node. If none exist, parent node will point to null
                subprevious.setLeft(successor.getRight());
            }
            else if(subprevious.getRight() == successor) { // not sure whether this will ever be true
                subprevious.setRight(successor.getRight());
            }
        }
        return root;
    }

}// end of class


class Node {
    private int key;
    private String value;
    private Node left;
    private Node right;

    public Node(int key, String val, Node left, Node right) {
        this.key = key;
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public boolean setKey(int k) {
        key = k;
        return true;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node n) {
        left = n;
    }

    public void setRight(Node n) {
        right = n;
    }
}



