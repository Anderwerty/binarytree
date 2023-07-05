package org.example;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(2);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(10);
        binarySearchTree.insert(-1);
        binarySearchTree.insert(-2);
        binarySearchTree.insert(-3);
        binarySearchTree.deleteKey(4);

        binarySearchTree.inorder();
    }
}
