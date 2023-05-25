package com.aishervice.service;

import java.util.ArrayList;

import com.aishervice.entities.Inventaris;
import com.aishervice.repository.InventarisRepository;

public class InventarisService {
    private InventarisRepository inventarisRepo;

    public InventarisService(InventarisRepository inventarisRepo) {
        this.inventarisRepo = inventarisRepo;
    }

    public ArrayList<Inventaris> getAllData() throws Exception {
        try {
            ArrayList<Inventaris> inventarisArray = this.inventarisRepo.findAll();
            return inventarisArray;
        } catch (Exception e) {
            throw e;
        }
    }


    public Inventaris getDataByIdInventaris(int id_inventaris) throws Exception {
        try {
            Inventaris inventaris = this.inventarisRepo.findByIdInventaris(id_inventaris);
            return inventaris;
        } catch (Exception e) {
            throw e;
        }
    }

    public Inventaris insertData(Inventaris inventaris) throws Exception {
        try {

            Inventaris result = this.inventarisRepo.store(inventaris);
            return result;

        } catch (Exception e) {
            throw e;
        }
    }

    public void updateStok(Inventaris inventaris) throws Exception {
        try {
            inventarisRepo.updateStok(inventaris);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteData(int id_inventaris) throws Exception {
        try {

            this.inventarisRepo.delete(id_inventaris);

        } catch (Exception e) {
            throw e;
        }
    }

}
