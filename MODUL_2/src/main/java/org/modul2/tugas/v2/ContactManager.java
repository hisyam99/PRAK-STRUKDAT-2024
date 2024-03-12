package org.modul2.tugas.v2;

class ContactManager {
    private Contact head;

    public ContactManager() {
        head = null;
    }

    public void tambahKontak(String nama, String nomorTelepon) {
        Contact newKontak = new Contact(nama, nomorTelepon);
        if (head == null) {
            head = newKontak;
        } else {
            Contact current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newKontak;
        }
        System.out.println("Kontak berhasil ditambahkan.");
    }

    public void tampilkanKontak() {
        if (head == null) {
            System.out.println("Tidak ada kontak tersedia.");
            return;
        }
        System.out.println("Daftar Kontak:");
        Contact current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void cariKontak(String nama) {
        if (head == null) {
            System.out.println("Kontak tidak ditemukan.");
            return;
        }
        Contact current = head;
        boolean ditemukan = false;
        while (current != null) {
            if (current.nama.equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan:");
                System.out.println(current);
                ditemukan = true;
                break;
            }
            current = current.next;
        }
        if (!ditemukan) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}