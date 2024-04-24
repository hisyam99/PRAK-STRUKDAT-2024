package org.modul4.tugas.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {
    private static final Map<String, Integer> candidates = new HashMap<>();

    public static void main(String[] args) {
        initializeCandidates();
        voteProcess();
        displayResults();
    }

    private static void initializeCandidates() {
        candidates.put("Kandidat A", 0);
        candidates.put("Kandidat B", 0);
        candidates.put("Kandidat C", 0);
    }

    private static void voteProcess() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Sistem Voting Online");
        System.out.println("Pilih kandidat yang ingin Anda dukung:");
        System.out.println("1. Kandidat B");
        System.out.println("2. Kandidat C");
        System.out.println("3. Kandidat A");
        System.out.println("Ketik 'selesai' untuk mengakhiri voting.");

        while (true) {
            System.out.print("Masukkan nama kandidat (atau ketik 'selesai' untuk keluar): ");
            String candidateName = scanner.nextLine();

            if (candidateName.equalsIgnoreCase("selesai")) {
                break;
            }

            if (candidates.containsKey(candidateName)) {
                candidates.put(candidateName, candidates.get(candidateName) + 1);
                System.out.println("Terima kasih, suara Anda untuk " + candidateName + " telah direkam.");
            } else {
                System.out.println("Kandidat tidak valid, harap pilih kandidat yang tersedia.");
            }
        }

        scanner.close();
    }

    private static void displayResults() {
        System.out.println("Hasil Voting:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate + ": " + candidates.get(candidate) + " suara");
        }
    }
}