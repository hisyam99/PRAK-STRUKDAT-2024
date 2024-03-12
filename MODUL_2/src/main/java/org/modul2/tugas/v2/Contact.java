package org.modul2.tugas.v2;

class Contact {
    String nama;
    String nomorTelepon;
    Contact next;

    public Contact(String nama, String nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Nomor Telepon: " + nomorTelepon;
    }
}