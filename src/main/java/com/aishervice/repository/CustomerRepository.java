package com.aishervice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aishervice.config.database;
import com.aishervice.entities.Customer;

public class CustomerRepository {
    
    private Connection conn;

    public CustomerRepository() {
        this.conn = database.getConnection("prod");
    }


    public ArrayList<Customer> getAllData() throws Exception {
        String syntax = "SELECT id_pelanggan, nama, no_hp, alamat, email FROM customer";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {
             
            ResultSet result = pstmt.executeQuery();

            int i=0;
            ArrayList<Customer> customers = new ArrayList<Customer>();
            Customer customer;
            while (result.next()) {
                customer = new Customer(result.getInt("id_pelanggan"), result.getString("nama"), result.getString("no_hp"), result.getString("alamat"), result.getString("email"));
                customers.add(customer);
            }

            return customers;

        } catch (Exception e) {
            throw e;
        }
    }

    public Customer getDataByIdPelanggan(int id_pelanggan) throws Exception {
        String syntax = "SELECT id_pelanggan, nama, no_hp, alamat, email FROM customer WHERE id_pelanggan=?";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

            pstmt.setInt(1, id_pelanggan);

            ResultSet result = pstmt.executeQuery();
            Customer customer = null;
            if (result.next()) {
                customer = new Customer(result.getInt("id_pelanggan"), result.getString("nama"), result.getString("no_hp"), result.getString("alamat"), result.getString("email"));
            }

            return customer;

        } catch (Exception e) {
            throw e;
        }
    }


    public void insertData(Customer customer) throws Exception {

        String syntax = "INSERT INTO customer(nama,no_hp,alamat,email) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

            pstmt.setString(1, customer.getNama());
            pstmt.setString(1, customer.getNoHp());
            pstmt.setString(1, customer.getAlamat());
            pstmt.setString(1, customer.getEmail());

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw e;
        }

    }

    public void deleteData(int id_pelanggan) throws Exception {
        String syntax = "DELETE FROM customer WHERE id_pelanggan=?";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

            pstmt.setInt(1, id_pelanggan);

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

}
