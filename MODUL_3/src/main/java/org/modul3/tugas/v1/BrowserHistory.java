package org.modul3.tugas.v1;

import java.util.Scanner;

public class BrowserHistory {
    private final String[] riwayat;
    private int indeksSaatIni;

    public BrowserHistory() {
        riwayat = new String[10];
        indeksSaatIni = -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BrowserHistory browser = new BrowserHistory();

        while (true) {
            System.out.println("1. Kunjungi URL");
            System.out.println("2. Mundur");
            System.out.println("3. Maju");
            System.out.println("4. URL Saat Ini");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int perintah = input.nextInt();
            input.nextLine();

            switch (perintah) {
                case 1:
                    System.out.print("Masukkan URL: ");
                    String url = input.nextLine();
                    browser.kunjungi(url);
                    break;
                case 2:
                    browser.mundur();
                    break;
                case 3:
                    browser.maju();
                    break;
                case 4:
                    browser.getURLSaatIni();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public void kunjungi(String url) {
        System.out.println(riwayat.length);
        System.out.println(indeksSaatIni);
        if (indeksSaatIni < riwayat.length - 1) {
            indeksSaatIni++;
            riwayat[indeksSaatIni] = url;
            System.out.println("Mengunjungi URL: " + url);
        } else {
            System.out.println("Batas riwayat sudah tercapai. Tidak dapat menambahkan URL lebih banyak.");
        }
    }

    public void mundur() {
        if (indeksSaatIni > 0) {
            indeksSaatIni--;
            System.out.println("Kembali ke: " + riwayat[indeksSaatIni]);
        } else {
            System.out.println("Tidak ada riwayat sebelumnya.");
        }
    }

    public void maju() {
        if (indeksSaatIni < riwayat.length - 1 && riwayat[indeksSaatIni + 1] != null) {
            indeksSaatIni++;
            System.out.println("Maju ke: " + riwayat[indeksSaatIni]);
        } else {
            System.out.println("Tidak dapat maju.");
        }
    }

    public void getURLSaatIni() {
        if (indeksSaatIni >= 0 && indeksSaatIni < riwayat.length && riwayat[indeksSaatIni] != null) {
            System.out.println("URL Saat Ini: " + riwayat[indeksSaatIni]);
        } else {
            System.out.println("Belum ada URL yang dikunjungi.");
        }
    }
}
