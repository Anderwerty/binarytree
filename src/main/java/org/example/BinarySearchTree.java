package org.example;

public class BinarySearchTree {
    private static class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public void insertAll(int[] keys) {
        for (int key : keys) {
            insert(key);
        }
    }

    public void insert(int key) {
        root = insertKey(root, key);
    }

    Node insertKey(Node root, int key) {
        if (root == null) {
            return createNode(key);
        }
        if (key < root.key) {
            root.left = insertKey(root.left, key);
        } else if (key > root.key) {
            root.right = insertKey(root.right, key);
        }

        return root;
    }

    private Node createNode(int key) {
        return new Node(key);
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " -> ");
            inorderRec(root.right);
        }
    }


    Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key < key) {
            return search(root.right, key);
        }

        return search(root.left, key);
    }
    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        // Return if the tree is empty
        if (root == null) {
            return root;
        }
        // Find the node to be deleted
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // If the node is with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.key = findMinValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // Find the inorder successor
    public int findMinValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.deleteKey(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}
