package com.aishervice.Repositories;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.aishervice.config.database;
import com.aishervice.entities.Customer;
import com.aishervice.repository.CustomerRepository;

public class CustomerRepositoryTest {
    
    private Connection conn = null;
    private CustomerRepository customerRepo;

    @BeforeEach
    public void setupEach() {
        this.conn = database.getConnection("test");
        this.customerRepo = new CustomerRepository();
        try {
            this.customerRepo.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testGetAllDataNotFound() {
        try {
            ArrayList<Customer> customer = this.customerRepo.findAll();
            Assertions.assertEquals(customer.size(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAllDataFound() {
        try {
            this.customerRepo.store(new Customer("Arya", "081215750405", "sukapura", "arya@gmail.com"));
            ArrayList<Customer> customer = this.customerRepo.findAll();
            Assertions.assertEquals(customer.size(), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDataByIdNotFound() {
        try {
            Customer customer = this.customerRepo.findByIdPelanggan(999);
            Assert.isNull(customer, "null");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDataByIdFound() {
        try {
            Customer insertedCustomer = this.customerRepo.store(new Customer("Arya", "081215750405", "sukapura", "arya@gmail.com"));
            Customer customer = this.customerRepo.findByIdPelanggan(insertedCustomer.getIdPelanggan());
            System.out.println(customer);
            Assertions.assertEquals(customer.getNama(), "Arya");
            Assertions.assertEquals(customer.getAlamat(), "sukapura");
            Assertions.assertEquals(customer.getEmail(), "arya@gmail.com");
            Assertions.assertEquals(customer.getNoHp(), "081215750405");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test 
    public void testInsertData() {
        try {
            Customer customer = this.customerRepo.store(new Customer("Arya", "081215750405", "sukapura", "arya@gmail.com"));
            Assertions.assertEquals(customer.getNama(), "Arya");
            Assertions.assertEquals(customer.getAlamat(), "sukapura");
            Assertions.assertEquals(customer.getEmail(), "arya@gmail.com");
            Assertions.assertEquals(customer.getNoHp(), "081215750405");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteData() {
        try {
             
            Customer customer = this.customerRepo.store(new Customer("Arya", "081215750405", "sukapura", "arya@gmail.com"));
            this.customerRepo.delete(customer.getIdPelanggan());

            customer = this.customerRepo.findByIdPelanggan(customer.getIdPelanggan());

            Assert.isNull(customer, "null");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
