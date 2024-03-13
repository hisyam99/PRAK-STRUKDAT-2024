package org.modul2.tugas.v1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ContactManager contactManager = new ContactManager();

            while (true) {
                System.out.println("\nSelamat datang di Manajemen Kontak!");
                System.out.println("1. Tambah Kontak");
                System.out.println("2. Tampilkan Kontak");
                System.out.println("3. Cari Kontak");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu (1/2/3/4): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan nama kontak: ");
                        String name = scanner.nextLine();
                        System.out.print("Masukkan nomor telepon: ");
                        String phoneNumber = scanner.nextLine();
                        contactManager.addContact(new Contact(name, phoneNumber));
                        break;
                    case 2:
                        contactManager.displayContacts();
                        break;
                    case 3:
                        System.out.print("Masukkan nama kontak yang ingin dicari: ");
                        String searchName = scanner.nextLine();
                        contactManager.searchContact(searchName);
                        break;
                    case 4:
                        System.out.println("Program berakhir.");
                        System.exit(0);
                    default:
                        System.out.println("Opsi tidak valid. Silakan pilih opsi yang benar.");
                }
            }
        }
    }
}
