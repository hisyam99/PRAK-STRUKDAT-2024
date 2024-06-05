package org.modul5.tugas.v2;

import java.util.Scanner;

public class ManajemenInventarisBuku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventarisBuku inventaris = new InventarisBuku();

        while (true) {
            System.out.println("Pilih opsi:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Tampilkan Buku (PreOrder)");
            System.out.println("4. Tampilkan Buku (InOrder)");
            System.out.println("5. Tampilkan Buku (PostOrder)");
            System.out.println("6. Keluar");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan ISBN:");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Masukkan Judul:");
                    String judul = scanner.nextLine();
                    inventaris.tambahBuku(isbn, judul);
                    break;
                case 2:
                    System.out.println("Masukkan ISBN yang dicari:");
                    int isbnCari = scanner.nextInt();
                    Buku hasil = inventaris.cariBuku(isbnCari);
                    if (hasil != null) {
                        System.out.println("Buku ditemukan: ISBN = " + hasil.isbn + ", Judul = " + hasil.judul);
                    } else {
                        System.out.println("Buku dengan ISBN " + isbnCari + " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("Inventaris Buku (PreOrder):");
                    inventaris.tampilkanPreOrder(inventaris.root);
                    break;
                case 4:
                    System.out.println("Inventaris Buku (InOrder):");
                    inventaris.tampilkanInOrder(inventaris.root);
                    break;
                case 5:
                    System.out.println("Inventaris Buku (PostOrder):");
                    inventaris.tampilkanPostOrder(inventaris.root);
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
