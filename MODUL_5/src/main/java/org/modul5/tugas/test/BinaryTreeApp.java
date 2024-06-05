package org.modul5.tugas.test;

import java.util.Scanner;

class TreeNode {
    String data;
    TreeNode kiri, kanan;

    TreeNode(String item) {
        data = item;
        kiri = kanan = null;
    }
}

class BinaryTrees {
    TreeNode root;

    void insert(String data) {
        root = insertRec(root, data);
    }

    TreeNode insertRec(TreeNode root, String data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data.compareTo(root.data) < 0)
            root.kiri = insertRec(root.kiri, data);
        else if (data.compareTo(root.data) > 0)
            root.kanan = insertRec(root.kanan, data);
        return root;
    }

    void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.kiri);
            preOrder(node.kanan);
        }
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.kiri);
            System.out.print(node.data + " ");
            inOrder(node.kanan);
        }
    }

    void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.kiri);
            postOrder(node.kanan);
            System.out.print(node.data + " ");
        }
    }

    TreeNode findPredecessor(TreeNode root, String key) {
        TreeNode predecessor = null;
        while (root != null) {
            if (key.compareTo(root.data) > 0) {
                predecessor = root;
                root = root.kanan;
            } else {
                root = root.kiri;
            }
        }
        return predecessor;
    }

    TreeNode findSuccessor(TreeNode root, String key) {
        TreeNode successor = null;
        while (root != null) {
            if (key.compareTo(root.data) < 0) {
                successor = root;
                root = root.kiri;
            } else {
                root = root.kanan;
            }
        }
        return successor;
    }

    boolean isAncestor(TreeNode root, String ancestor, String key) {
        if (root == null) return false;
        if (root.data.equals(ancestor)) return find(root, key);
        return isAncestor(root.kiri, ancestor, key) || isAncestor(root.kanan, ancestor, key);
    }

    boolean find(TreeNode root, String key) {
        if (root == null) return false;
        if (root.data.equals(key)) return true;
        return find(root.kiri, key) || find(root.kanan, key);
    }
}

public class BinaryTreeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTrees tree = new BinaryTrees();

        System.out.println("Masukkan elemen (huruf dan angka) untuk Binary Tree, dipisahkan dengan spasi:");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");

        for (String element : elements) {
            tree.insert(element);
        }

        System.out.println("\nTraversal PreOrder:");
        tree.preOrder(tree.root);

        System.out.println("\nTraversal InOrder:");
        tree.inOrder(tree.root);

        System.out.println("\nTraversal PostOrder:");
        tree.postOrder(tree.root);

        System.out.println("\nMasukkan sebuah node untuk menemukan predecessor dan successornya:");
        String key = scanner.nextLine();
        TreeNode predecessor = tree.findPredecessor(tree.root, key);
        TreeNode successor = tree.findSuccessor(tree.root, key);

        System.out.println("Predecessor dari " + key + ": " + (predecessor != null ? predecessor.data : "Tidak ada"));
        System.out.println("Successor dari " + key + ": " + (successor != null ? successor.data : "Tidak ada"));

        System.out.println("\nMasukkan dua node untuk memeriksa apakah yang pertama adalah ancestor dari yang kedua:");
        String ancestor = scanner.next();
        String descendant = scanner.next();
        boolean isAncestor = tree.isAncestor(tree.root, ancestor, descendant);

        System.out.println(ancestor + " " + (isAncestor ? "adalah" : "bukan") + " ancestor dari " + descendant);
    }
}
