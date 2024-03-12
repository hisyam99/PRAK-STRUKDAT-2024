// Muhammad Hisyam Kamil
// 202210370311060
// Struktur Data 4D

package com.modul1.demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan harga barang: ");
        double hargaBarang = scanner.nextDouble();

        System.out.println("Pilih tipe barang:");
        for (TipeBarang tipe : TipeBarang.values()) {
            System.out.println((tipe.ordinal() + 1) + ". " + tipe);
        }
        System.out.print("Masukkan pilihan: ");
        int pilihanTipe = scanner.nextInt();
        TipeBarang tipeBarang = TipeBarang.values()[pilihanTipe - 1];

        scanner.close();

        Barang<String, Double> barang = new Barang<>(namaBarang, hargaBarang, tipeBarang);

        System.out.println("\nInformasi Barang:");
        System.out.println("Nama: " + barang.getNama());
        System.out.println("Harga: " + barang.getHarga());
        System.out.println("Tipe: " + barang.getTipe());
    }
}
