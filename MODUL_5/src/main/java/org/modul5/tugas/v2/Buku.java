package org.modul5.tugas.v2;

class Buku {
    int isbn;
    String judul;
    Buku kiri, kanan;

    public Buku(int isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
        kiri = kanan = null;
    }
}
