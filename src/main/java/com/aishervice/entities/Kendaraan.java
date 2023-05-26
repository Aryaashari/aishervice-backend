package com.aishervice.entities;

public class Kendaraan {
    private String noPlat;
    private int idPelanggan;
    private String noMesin;
    private String JenisKendaraan;

    public Kendaraan(int idPelanggan, String noPlat, String noMesin, String jenisKendaraan ) {
        this.idPelanggan = idPelanggan;
        this.noPlat = noPlat;
        this.noMesin = noMesin;
        JenisKendaraan = jenisKendaraan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNoPlat() {
        return noPlat;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public String getNoMesin() {
        return noMesin;
    }

    public String getJenisKendaraan() {
        return JenisKendaraan;
    }

    

    
}
