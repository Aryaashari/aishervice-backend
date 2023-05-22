package com.aishervice.entities;

public class Customer {
    private int idPelanggan;
    private String nama;
    private String noHp;
    private String alamat;
    private String email;

    public Customer(int idPelanggan, String nama, String noHp, String alamat, String email) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.email = email;
    }

    public int getIdPelanggan() {
        return this.idPelanggan;
    }

    public String getNama() {
        return this.nama;
    }

    public String getNoHp() {
        return this.noHp;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public String getEmail() {
        return this.email;
    }
}
