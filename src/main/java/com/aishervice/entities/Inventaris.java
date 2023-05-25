package com.aishervice.entities;

public class Inventaris {
    private int id_inventaris, stok;
    private float harga_satuan;
    private String suku_cadang;

    public Inventaris(String suku_cadang, int stok, float harga_satuan){
        this.suku_cadang = suku_cadang;
        this.stok = stok;
        this.harga_satuan = harga_satuan;
    }

    public int getId_inventaris() {
        return id_inventaris;
    }

    public void setId_inventaris(int id_inventaris) {
        this.id_inventaris = id_inventaris;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public float getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(int harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    public String getSuku_cadang() {
        return suku_cadang;
    }

    public void setSuku_cadang(String suku_cadang) {
        this.suku_cadang = suku_cadang;
    }

    
}
