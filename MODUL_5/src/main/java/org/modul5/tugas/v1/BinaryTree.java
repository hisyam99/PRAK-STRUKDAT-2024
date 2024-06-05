package org.modul5.tugas.v1;

import java.util.Scanner;

class BinaryTree {
    public Node rootNode;

    public BinaryTree() {
        rootNode = null;
    }

    public void setRoot(String value) {
        rootNode = new Node(value);
    }

    public void insert(Node parent, String value, String direction) {
        if (direction.equals("L")) {
            parent.leftChild = new Node(value);
        } else if (direction.equals("R")) {
            parent.rightChild = new Node(value);
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.leftChild);
            System.out.print(node.value + " ");
            traverseInOrder(node.rightChild);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traversePreOrder(node.leftChild);
            traversePreOrder(node.rightChild);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.leftChild);
            traversePostOrder(node.rightChild);
            System.out.print(node.value + " ");
        }
    }

    public Node searchNode(Node node, String value) {
        if (node == null) return null;
        if (node.value.equals(value)) return node;
        Node leftResult = searchNode(node.leftChild, value);
        if (leftResult != null) return leftResult;
        return searchNode(node.rightChild, value);
    }

    public void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTree(node.leftChild, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.rightChild, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        System.out.print("Enter root value: ");
        String rootValue = scanner.nextLine();
        binaryTree.setRoot(rootValue);

        while (true) {
            System.out.print("Enter parent, value, and direction (L/R) or 'exit' to finish: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                String[] parts = input.split(" ");
                String parentValue = parts[0];
                String value = parts[1];
                String direction = parts[2];

                Node parentNode = binaryTree.searchNode(binaryTree.rootNode, parentValue);
                if (parentNode != null) {
                    binaryTree.insert(parentNode, value, direction);
                } else {
                    System.out.println("Parent not found.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.println("\nPre Order: ");
        binaryTree.traversePreOrder(binaryTree.rootNode);
        System.out.println("\nIn Order: ");
        binaryTree.traverseInOrder(binaryTree.rootNode);
        System.out.println("\nPost Order: ");
        binaryTree.traversePostOrder(binaryTree.rootNode);

        System.out.println("\nTree Visualization: ");
        binaryTree.printTree(binaryTree.rootNode, "", false);

        scanner.close();
    }
}
