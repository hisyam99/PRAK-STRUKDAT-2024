package org.modul3.tugas.v2;

import java.util.Scanner;

public class TicketBookingSystem {
    private static int nomorPemesananCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketQueue queue = new TicketQueue();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Hapus Pemesanan Tiket");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Masukkan nama pemesan: ");
                    String namaPemesan = scanner.nextLine();
                    System.out.print("Masukkan jumlah tiket: ");
                    int jumlahTiket = scanner.nextInt();
                    queue.enqueue(namaPemesan, jumlahTiket, nomorPemesananCounter++);
                    break;
                case 2:
                    queue.displayQueue();
                    break;
                case 3:
                    queue.dequeue();
                    break;
                case 4:
                    running = false;
                    break;
                case 5:
                    queue.frontrearandrearnext();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
        System.out.println("Terima kasih telah menggunakan sistem pemesanan tiket.");
    }
}