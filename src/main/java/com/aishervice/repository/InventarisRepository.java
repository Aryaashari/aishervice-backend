package com.aishervice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aishervice.config.database;
import com.aishervice.entities.Inventaris;

public class InventarisRepository {
    private Connection conn;

    public InventarisRepository() {
        this.conn = database.getConnection("prod");
    }


    public ArrayList<Inventaris> findAll() throws Exception {
        String syntax = "SELECT id_inventaris, suku_cadang, stok, harga_satuan FROM inventaris";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {
             
            ResultSet result = pstmt.executeQuery();

            ArrayList<Inventaris> inventarisArray = new ArrayList<Inventaris>();
            Inventaris objInventaris;
            while (result.next()) {
                objInventaris = new Inventaris(result.getString("suku_cadang"), result.getInt("stok"), result.getFloat("harga_satuan"));
                objInventaris.setId_inventaris(result.getInt("id_inventaris"));
                inventarisArray.add(objInventaris);
            }

            return inventarisArray;

        } catch (Exception e) {
            throw e;
        }
    }

    public Inventaris findByIdInventaris(int id_inventaris) throws Exception {
        String syntax = "SELECT id_inventaris, suku_cadang, stok, harga_satuan FROM inventaris WHERE id_inventaris=?";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

            pstmt.setInt(1, id_inventaris);

            ResultSet result = pstmt.executeQuery();
            Inventaris objInventaris = null;
            if (result.next()) {
                objInventaris = new Inventaris(result.getString("suku_cadang"), result.getInt("stok"), result.getFloat("harga_satuan"));
                objInventaris.setId_inventaris(result.getInt("id_inventaris"));
            }

            return objInventaris;

        } catch (Exception e) {
            throw e;
        }
    }


    public Inventaris store(Inventaris objInventaris) throws Exception {

        String syntax = "INSERT INTO inventaris(suku_cadang,stok,harga_satuan) VALUES(?,?,?)";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

            pstmt.setString(1, objInventaris.getSuku_cadang());
            pstmt.setInt(2, objInventaris.getStok());
            pstmt.setFloat(3, objInventaris.getHarga_satuan());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int lastInsertedId = generatedKeys.getInt(1);
                    objInventaris.setId_inventaris(lastInsertedId);
                }
            }

            return objInventaris;

        } catch (Exception e) {
            throw e;
        }

    }

    public void updateStok(Inventaris inventaris) throws Exception {
        String syntax = "UPDATE inventaris SET stok = ? WHERE id_inventaris = ?";
    
        try (PreparedStatement pstmt = conn.prepareStatement(syntax)) {
            pstmt.setInt(1, inventaris.getStok());
            pstmt.setInt(2, inventaris.getId_inventaris());
    
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id_inventaris) throws Exception {
        String syntax = "DELETE FROM inventaris WHERE id_inventaris=?";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

            pstmt.setInt(1, id_inventaris);

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteAll() throws Exception {
        String syntax = "DELETE FROM inventaris";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
