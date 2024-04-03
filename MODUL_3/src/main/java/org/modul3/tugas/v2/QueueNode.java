package org.modul3.tugas.v2;

class QueueNode {
    String namaPemesan;
    int jumlahTiket;
    int nomorPemesanan;
    QueueNode next;

    public QueueNode(String namaPemesan, int jumlahTiket, int nomorPemesanan) {
        this.namaPemesan = namaPemesan;
        this.jumlahTiket = jumlahTiket;
        this.nomorPemesanan = nomorPemesanan;
        this.next = null;
    }
}
