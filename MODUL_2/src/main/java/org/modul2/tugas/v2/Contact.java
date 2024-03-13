package org.modul2.tugas.v2;

class Contact<T> {
    private T nama;
    private T nomorTelepon;
    private Contact<T> next;

    public Contact(T nama, T nomorTelepon) {
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.next = null;
    }

    public T getNama() {
        return nama;
    }

    public T getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNext(Contact<T> next) {
        this.next = next;
    }

    public Contact<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Nomor Telepon: " + nomorTelepon;
    }
}