package com.modul1.demo;

public class Barang<T, U> {
    private T nama;
    private U harga;
    private TipeBarang tipe;
    
    public Barang(T nama, U harga, TipeBarang tipe) {
        this.nama = nama;
        this.harga = harga;
        this.tipe = tipe;
    }

    public T getNama() {
        return nama;
    }

    public U getHarga() {
        return harga;
    }

    public TipeBarang getTipe() {
        return tipe;
    }
}
