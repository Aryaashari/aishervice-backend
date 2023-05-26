package com.aishervice.service;

import java.util.ArrayList;

import com.aishervice.entities.Kendaraan;
import com.aishervice.repository.KendaraanRepository;

public class KendaraanService {
    
    private KendaraanRepository  kendaraanRepo;

    public KendaraanService(KendaraanRepository kendaraanRepo) {
        this.kendaraanRepo = kendaraanRepo;
    }

    public ArrayList<Kendaraan> getAllData() throws Exception {
        try {
            ArrayList<Kendaraan> kendaraans = this.kendaraanRepo.findAll();
            return kendaraans;
        } catch (Exception e) {
            throw e;
        }
    }

    public Kendaraan getDataByIdPelanggan(int id_pelanggan) throws Exception {
        try {
            Kendaraan kendaraans = this.kendaraanRepo.findByIdPelanggan(id_pelanggan);
            return kendaraans;
        } catch (Exception e) {
            throw e;
        }
    }

    public Kendaraan insertData(Kendaraan kendaraan) throws Exception {
        try {

            Kendaraan result = this.kendaraanRepo.store(kendaraan);
            return result;

        } catch (Exception e) {
            throw e;
        }
    }


    public void deleteData(int idPelanggan) throws Exception {
        try {

            this.kendaraanRepo.delete(idPelanggan);

        } catch (Exception e) {
            throw e;
        }
    }
}
