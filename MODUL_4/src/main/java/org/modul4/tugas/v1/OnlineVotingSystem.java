package org.modul4.tugas.v1;

import java.util.HashMap;
import java.util.Scanner;

public class OnlineVotingSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> candidates = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Sistem Voting Online");
        System.out.println("Pilih kandidat yang ingin Anda dukung:");
        System.out.println("1. Kandidat B");
        System.out.println("2. Kandidat C");
        System.out.println("3. Kandidat A");

        while (true) {
            System.out.print("Masukkan nama kandidat (atau ketik 'selesai' untuk keluar): ");
            String candidateName = scanner.nextLine();

            if (candidateName.equalsIgnoreCase("selesai")) {
                break;
            }

            candidates.put(candidateName, candidates.getOrDefault(candidateName, 0) + 1);
            System.out.println("Terima kasih, suara Anda telah direkam.");
        }

        System.out.println("Hasil Voting:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate + ": " + candidates.get(candidate) + " suara");
        }

        scanner.close();
    }
}
