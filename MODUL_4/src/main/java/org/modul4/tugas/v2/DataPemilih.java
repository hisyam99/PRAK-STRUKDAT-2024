package org.modul4.tugas.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class DataPemilih {
    private final HashMap<String, Integer> candidates = new HashMap<>();
    private final HashMap<String, String> users = new HashMap<>();
    private final HashMap<String, ArrayList<String>> userDetails = new HashMap<>();
    private final HashSet<String> votedUsers = new HashSet<>();

    private String loggedInUser = null;

    public void register(Scanner scanner) {
        try {
            System.out.print("Masukkan email: ");
            String email = scanner.nextLine();

            if (!email.endsWith("@gmail.com")) {
                throw new Exception("Format email harus menggunakan '@gmail.com'.");
            }

            if (users.containsKey(email)) {
                throw new Exception("Email sudah terdaftar.");
            }

            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();
            System.out.print("Masukkan nama: ");
            String name = scanner.nextLine();
            System.out.print("Masukkan NIK: ");
            String nik = scanner.nextLine();

            users.put(email, password);
            ArrayList<String> userDetailsList = new ArrayList<>();
            userDetailsList.add(name);
            userDetailsList.add(nik);
            userDetails.put(email, userDetailsList);

            System.out.println("Berhasil Mendaftar");

            System.out.print("Apakah ingin register lagi? (ya/tidak): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("ya")) {
                login(scanner);
            } else {

                OnlineVotingSystem votingSystem = new OnlineVotingSystem();
                votingSystem.showMainMenu();
            }
        } catch (Exception e) {
            System.out.println("Gagal Mendaftar: " + e.getMessage());
            OnlineVotingSystem votingSystem = new OnlineVotingSystem();
            votingSystem.showMainMenu();
        }
    }

    public void login(Scanner scanner) {
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();

        try {
            if (!email.endsWith("@gmail.com") || !users.containsKey(email)) {
                throw new Exception("Email tidak terdaftar atau format email salah.");
            }

            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (!users.get(email).equals(password)) {
                throw new Exception("Password salah.");
            }

            System.out.println("Login Berhasil");
            loggedInUser = email;
            ArrayList<String> userDetailsList = userDetails.get(email);
            System.out.println("Nama: " + userDetailsList.get(0));
            System.out.println("NIK: " + userDetailsList.get(1));
            showVotingOptions(scanner);
        } catch (Exception e) {
            System.out.println("Gagal Login: " + e.getMessage());
            OnlineVotingSystem votingSystem = new OnlineVotingSystem();
            votingSystem.showMainMenu();
        }
    }

    public void initializeCandidates() {
        candidates.put("Kandidat A", 0);
        candidates.put("Kandidat B", 0);
        candidates.put("Kandidat C", 0);
    }

    public void showVotingOptions(Scanner scanner) {
        System.out.println("Selamat datang di sistem voting:");
        System.out.println("Pilih kandidat yang ingin Anda dukung:");
        System.out.println("- Kandidat A");
        System.out.println("- Kandidat B");
        System.out.println("- Kandidat C");
        System.out.print("Masukkan nama kandidat (atau ketik 'selesai' untuk keluar): ");
        String candidateName = scanner.nextLine();

        switch (candidateName) {
            case "Kandidat A":
            case "Kandidat B":
            case "Kandidat C":
                vote(candidateName);
                break;
            case "selesai":
                OnlineVotingSystem votingSystem = new OnlineVotingSystem();
                votingSystem.showMainMenu();
                break;
            default:
                System.out.println("Opsi tidak valid. Harap pilih kandidat yang tersedia.");
                showVotingOptions(scanner);
        }
    }

    public void vote(String candidateName) {
        if (loggedInUser == null) {
            System.out.println("Anda harus login untuk memilih.");
            return;
        }

        if (votedUsers.contains(loggedInUser)) {
            System.out.println("Anda sudah memilih dan tidak dapat memilih lagi.");
            OnlineVotingSystem votingSystem = new OnlineVotingSystem();
            votingSystem.showMainMenu();
            return;
        }

        if (candidates.containsKey(candidateName)) {
            candidates.put(candidateName, candidates.get(candidateName) + 1);
        }

        votedUsers.add(loggedInUser);
        System.out.println("Terima kasih, suara Anda telah direkam.");
        showVotingOptions(new Scanner(System.in));
    }


    public void displayResults() {
        System.out.println("Hasil Voting:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate + ": " + candidates.get(candidate) + " suara");
        }
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Anda telah logout dari sistem voting.");
    }
}
