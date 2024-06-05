package org.modul5.tugas.test;

class Node {
    String value;
    Node leftChild;
    Node rightChild;

    public Node(String value) {
        this.value = value;
    }
}

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

    public void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
            printTree(node.leftChild, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.rightChild, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // Set root as "Hero Genre"
        binaryTree.setRoot("Hero Genre");

        // Insert genres
        binaryTree.insert(binaryTree.rootNode, "Warrior", "L");
        binaryTree.insert(binaryTree.rootNode, "Mage", "R");

        // Insert heroes under "Warrior"
        Node warriorNode = binaryTree.rootNode.leftChild;
        binaryTree.insert(warriorNode, "Arthur", "L");
        binaryTree.insert(warriorNode, "Lancelot", "R");

        // Insert heroes under "Mage"
        Node mageNode = binaryTree.rootNode.rightChild;
        binaryTree.insert(mageNode, "Merlin", "L");
        binaryTree.insert(mageNode, "Morgana", "R");

        // Insert skills under "Arthur"
        Node arthurNode = warriorNode.leftChild;
        binaryTree.insert(arthurNode, "Excalibur Strike", "L");
        binaryTree.insert(arthurNode, "Shield Bash", "R");

        // Insert skills under "Lancelot"
        Node lancelotNode = warriorNode.rightChild;
        binaryTree.insert(lancelotNode, "Dual Blade", "L");
        binaryTree.insert(lancelotNode, "Charge Attack", "R");

        // Insert skills under "Merlin"
        Node merlinNode = mageNode.leftChild;
        binaryTree.insert(merlinNode, "Fireball", "L");
        binaryTree.insert(merlinNode, "Teleport", "R");

        // Insert skills under "Morgana"
        Node morganaNode = mageNode.rightChild;
        binaryTree.insert(morganaNode, "Dark Magic", "L");
        binaryTree.insert(morganaNode, "Mind Control", "R");

        // Print tree visualization
        System.out.println("Tree Visualization:");
        binaryTree.printTree(binaryTree.rootNode, "", false);
    }
}
