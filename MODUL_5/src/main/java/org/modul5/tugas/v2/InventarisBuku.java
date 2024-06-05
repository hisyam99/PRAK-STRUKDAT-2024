package org.modul5.tugas.v2;

class InventarisBuku {
    Buku root;

    // Menambahkan buku ke inventaris
    void tambahBuku(int isbn, String judul) {
        root = tambahBukuRec(root, isbn, judul);
    }

    Buku tambahBukuRec(Buku root, int isbn, String judul) {
        if (root == null) {
            root = new Buku(isbn, judul);
            return root;
        }
        if (isbn < root.isbn) {
            root.kiri = tambahBukuRec(root.kiri, isbn, judul);
        } else if (isbn > root.isbn) {
            root.kanan = tambahBukuRec(root.kanan, isbn, judul);
        }
        return root;
    }

    // Mencari buku berdasarkan ISBN
    Buku cariBuku(int isbn) {
        return cariBukuRec(root, isbn);
    }

    Buku cariBukuRec(Buku root, int isbn) {
        if (root == null || root.isbn == isbn) {
            return root;
        }
        if (root.isbn > isbn) {
            return cariBukuRec(root.kiri, isbn);
        }
        return cariBukuRec(root.kanan, isbn);
    }

    // Menampilkan semua buku dalam inventaris secara PreOrder
    void tampilkanPreOrder(Buku node) {
        if (node != null) {
            System.out.println("ISBN: " + node.isbn + ", Judul: " + node.judul);
            tampilkanPreOrder(node.kiri);
            tampilkanPreOrder(node.kanan);
        }
    }

    // Menampilkan semua buku dalam inventaris secara InOrder
    void tampilkanInOrder(Buku node) {
        if (node != null) {
            tampilkanInOrder(node.kiri);
            System.out.println("ISBN: " + node.isbn + ", Judul: " + node.judul);
            tampilkanInOrder(node.kanan);
        }
    }

    // Menampilkan semua buku dalam inventaris secara PostOrder
    void tampilkanPostOrder(Buku node) {
        if (node != null) {
            tampilkanPostOrder(node.kiri);
            tampilkanPostOrder(node.kanan);
            System.out.println("ISBN: " + node.isbn + ", Judul: " + node.judul);
        }
    }
}
