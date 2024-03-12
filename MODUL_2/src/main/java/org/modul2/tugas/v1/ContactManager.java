package org.modul2.tugas.v1;

import java.util.ArrayList;

class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Daftar kontak kosong.");
            return;
        }
        System.out.println("Daftar Kontak:");
        for (Contact contact : contacts) {
            System.out.println("Nama: " + contact.getName() + ", Nomor Telepon: " + contact.getPhoneNumber());
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan!");
                System.out.println("Nama: " + contact.getName() + ", Nomor Telepon: " + contact.getPhoneNumber());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kontak dengan nama '" + name + "' tidak ditemukan.");
        }
    }
}