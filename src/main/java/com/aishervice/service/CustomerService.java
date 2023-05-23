package com.aishervice.service;

import java.util.ArrayList;

import com.aishervice.entities.Customer;
import com.aishervice.repository.CustomerRepository;

public class CustomerService {
    
    private CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public ArrayList<Customer> getAllData() throws Exception {
        try {
            ArrayList<Customer> customers = this.customerRepo.findAll();
            return customers;
        } catch (Exception e) {
            throw e;
        }
    }


    public Customer getDataByIdPelanggan(int id_pelanggan) throws Exception {
        try {
            Customer customer = this.customerRepo.findByIdPelanggan(id_pelanggan);
            return customer;
        } catch (Exception e) {
            throw e;
        }
    }

    public Customer insertData(Customer customer) throws Exception {
        try {

            Customer result = this.customerRepo.store(customer);
            return result;

        } catch (Exception e) {
            throw e;
        }
    }


    public void deleteData(int idPelanggan) throws Exception {
        try {

            this.customerRepo.delete(idPelanggan);

        } catch (Exception e) {
            throw e;
        }
    }

}
