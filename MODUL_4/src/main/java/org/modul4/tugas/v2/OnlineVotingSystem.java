package org.modul4.tugas.v2;

import java.util.Scanner;

public class OnlineVotingSystem {
    private static final DataPemilih dataPemilih = new DataPemilih();

    public static void main(String[] args) {
        OnlineVotingSystem votingSystem = new OnlineVotingSystem();
        dataPemilih.initializeCandidates();
        votingSystem.showMainMenu();
    }

    public void showMainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Selamat datang di Sistem Voting Online");
            System.out.println("Pilihan menu:");
            System.out.println("1. Login");
            System.out.println("2. Daftar");
            System.out.println("3. Hasil Vote");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    dataPemilih.login(scanner);
                    break;
                case 2:
                    dataPemilih.register(scanner);
                    break;
                case 3:
                    dataPemilih.displayResults();
                    break;
                case 4:
                    dataPemilih.logout();
                    System.out.println("Terima kasih telah menggunakan Sistem Voting Online.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Program berhenti.");
        }
    }
}