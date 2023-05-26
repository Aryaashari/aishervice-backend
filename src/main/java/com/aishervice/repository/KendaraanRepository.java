package com.aishervice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aishervice.config.database;
import com.aishervice.entities.Kendaraan;

public class KendaraanRepository {
   
    private Connection conec;

    public KendaraanRepository() {
        this.conec = database.getConnection("prod");
    }

    public ArrayList<Kendaraan> findAll() throws Exception {
        String syntax = "SELECT no_plat, id_pelanggan, nomor_mesin, jenis_kendaraan FROM kendaraan";

        try (PreparedStatement pstmt = this.conec.prepareStatement(syntax)) {

            ResultSet result = pstmt.executeQuery();

            ArrayList<Kendaraan> kendaraanList = new ArrayList<Kendaraan>();
            Kendaraan kendaraan;
            while (result.next()) {
                kendaraan = new Kendaraan(result.getInt("id_pelanggan"), result.getString("no_plat"), result.getString("nomor_mesin"), result.getString("jenis_kendaraan"));
                // kendaraan.setIdPelanggan(result.getInt("id_pelanggan"));
                kendaraanList.add(kendaraan);
            }

            return kendaraanList;
        } catch (Exception e) {
            throw e;
        }
    }

    public Kendaraan findByIdPelanggan(int id_pelanggan) throws Exception {
        String syntax = "no_plat, id_pelanggan, nomor_mesin, jenis_kendaraan FROM kendaraan WHERE id_pelanggan= ?";

        try (PreparedStatement pstmt = this.conec.prepareStatement(syntax)) {

            pstmt.setInt(1, id_pelanggan);

            ResultSet result = pstmt.executeQuery();
            Kendaraan kendaraan = null;
            if (result.next()) {
                kendaraan = new Kendaraan(result.getInt("id_pelanggan"), result.getString("no_plat"), result.getString("nomor_mesin"), result.getString("jenis_kendaraan"));
                // kendaraan.setIdPelanggan(result.getInt("id_pelanggan"));
            }

            return kendaraan;

        } catch (Exception e) {
            throw e;
        }
    }

    public Kendaraan store(Kendaraan kendaraan) throws Exception {

        String syntax = "INSERT INTO Kendaraan(no_plat, id_pelanggan, nomor_mesin,jenis_kendaraan) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = this.conec.prepareStatement(syntax)) {
            pstmt.setString(1, kendaraan.getNoPlat());
            pstmt.setInt(2, kendaraan.getIdPelanggan());
            pstmt.setString(3, kendaraan.getNoMesin());
            pstmt.setString(4, kendaraan.getJenisKendaraan());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int lastInsertedId = generatedKeys.getInt(1);
                    kendaraan.setIdPelanggan(lastInsertedId);
                }
            }

            return kendaraan;

        } catch (Exception e) {
            throw e;
        }

    }

    public void delete(int id_pelanggan) throws Exception {
        String syntax = "DELETE FROM kendaraan WHERE id_pelanggan=?";

        try (PreparedStatement pstmt = this.conec.prepareStatement(syntax)) {

            pstmt.setInt(1, id_pelanggan);

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    





}
