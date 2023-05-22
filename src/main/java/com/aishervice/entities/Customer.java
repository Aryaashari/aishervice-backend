package com.aishervice.entities;

public class Customer {
    private int idPelanggan;
    private String nama;
    private String noHp;
    private String alamat;
    private String email;

    public Customer(String nama, String noHp, String alamat, String email) {
        this.nama = nama;
        this.noHp = noHp;
        this.alamat = alamat;
        this.email = email;
        
    }

    public void setIdPelanggan(int id_pelanggan) {
        this.idPelanggan = id_pelanggan;
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
