package com.aishervice.entities;

import java.security.Timestamp;

public class Progress {
    private int id_proses, id_service;
    private String catatan_proses;
    private java.sql.Timestamp waktu_progress;

    public Progress(int id_service, String catatan_proses, java.sql.Timestamp timestamp){
        this.id_service = id_service;
        this.catatan_proses = catatan_proses;
        this.waktu_progress = timestamp;
    }

    public int getId_proses() {
        return id_proses;
    }

    public void setId_proses(int id_proses) {
        this.id_proses = id_proses;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getCatatan_proses() {
        return catatan_proses;
    }

    public void setCatatan_proses(String catatan_proses) {
        this.catatan_proses = catatan_proses;
    }

    public java.sql.Timestamp getWaktu_progress() {
        return waktu_progress;
    }

    public void setWaktu_progress(java.sql.Timestamp waktu_progress) {
        this.waktu_progress = waktu_progress;
    }

    
}
