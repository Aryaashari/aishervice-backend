package com.aishervice.Repositories;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.aishervice.config.database;
import com.aishervice.entities.Admin;
import com.aishervice.repository.AdminRepository;

public class AdminRepositoryTest {

    private Connection conn = null;
    private AdminRepository adminRepo;

    @BeforeEach
    public void setupEach() {
        this.conn = database.getConnection("test");
        this.adminRepo = new AdminRepository();
        // this.adminRepo.deleteAll();
    }

    @Test
    public void testGetDataByUsernameNull() {
        Admin admin;

        admin = this.adminRepo.getDataByUsername("arya");
        Assert.isNull(admin, "null");
    } 
    
    @Test
    public void testGetDataByUsernameNotNUll() {
        Admin admin;

        admin = this.adminRepo.getDataByUsername("arya");
        Assertions.assertEquals(admin.getUsername(), "arya");
        Assertions.assertEquals(admin.getPassword(), "arya");
    }   
}
