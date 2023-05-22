package com.aishervice.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aishervice.config.database;
import com.aishervice.entities.Admin;

public class AdminRepository {
    
    public static Connection conn;
    public static AdminRepository adminRepo;

    public AdminRepository() {
        this.conn = database.getConnection("prod");
    }


    public Admin getDataByUsername(String username) {
        
        String syntax = "SELECT username, password FROM admin WHERE username=?";
        
        Admin admin = null;
        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {
            pstmt.setString(1, username);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                admin = new Admin(result.getString("username"), result.getString("password"));
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return admin;
    }

    public void deleteAll() {
        String syntax = "DELETE FROM admin";

        try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {
            int rowAffected = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
