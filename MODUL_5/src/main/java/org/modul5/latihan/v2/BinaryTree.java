package org.modul5.latihan.v2;

public class BinaryTree {
    public Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.NewNode(20);
        tree.NewNode(2);
        tree.NewNode(25);
        tree.NewNode(37);
        tree.NewNode(16);

        System.out.println("\nPre Order: ");
        tree.preOrder(tree.root);
        System.out.println("\n\nIn Order: ");
        tree.inOrder(tree.root);
        System.out.println("\n\nPost Order: ");
        tree.postOrder(tree.root);
    }

    public void NewNode(int data) {
        root = NewNode(root, new Node(data));
    }

    private Node NewNode(Node root, Node newNode) {
        if (root == null) {
            root = newNode;
            return root;
        }

        if (newNode.data < root.data) {
            root.left = NewNode(root.left, newNode);
        } else {
            root.right = NewNode(root.right, newNode);
        }

        return root;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

