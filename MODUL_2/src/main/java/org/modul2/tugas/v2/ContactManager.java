package org.modul2.tugas.v2;

class ContactManager<T> {
    private Contact<T> head;

    public ContactManager() {
        head = null;
    }

    public void tambahKontak(T nama, T nomorTelepon) {
        Contact<T> newKontak = new Contact<>(nama, nomorTelepon);
        if (head == null) {
            head = newKontak;
        } else {
            Contact<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newKontak);
        }
        System.out.println("Kontak berhasil ditambahkan.");
    }

    public void tampilkanKontak() {
        if (head == null) {
            System.out.println("Tidak ada kontak tersedia.");
            return;
        }
        System.out.println("Daftar Kontak:");
        Contact<T> current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public void cariKontak(T nama) {
        if (head == null) {
            System.out.println("Kontak tidak ditemukan.");
            return;
        }
        Contact<T> current = head;
        boolean ditemukan = false;
        while (current != null) {
            if (current.getNama().equals(nama)) {
                System.out.println("Kontak ditemukan:");
                System.out.println(current);
                ditemukan = true;
                break;
            }
            current = current.getNext();
        }
        if (!ditemukan) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}