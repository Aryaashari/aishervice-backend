package com.aishervice.controllers;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aishervice.entities.Customer;
import com.aishervice.repository.CustomerRepository;
import com.aishervice.service.CustomerService;

import org.springframework.ui.Model;

@Controller
public class PelangganController {

    private CustomerService customerService;

    public PelangganController() {
        this.customerService = new CustomerService(new CustomerRepository());
    }
    
    @GetMapping("/pelanggan")
    public String pelanggan(Model model){
        try {

            ArrayList<Customer> customers = this.customerService.getAllData();
            model.addAttribute("currentPage", "pelanggan");
            model.addAttribute("customers", customers);

            System.out.println("hallo");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "pelanggan";
    }

    @PostMapping("/pelanggan")
    public String tambahPelanggan(@RequestParam("nama") String nama, @RequestParam("email") String email, @RequestParam("no_hp") String noHp, @RequestParam("alamat") String alamat, RedirectAttributes redirectAttributes) {
        try {
            Customer customer = new Customer(nama, noHp, alamat, email);
            this.customerService.insertData(customer);
            redirectAttributes.addFlashAttribute("success", "Data berhasil ditambahkan!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/pelanggan";
    }


    // Belum jadi
    // @PostMapping("/pelanggan/delete")
    // public String deletePelanggan(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
    //     try {

    //         this.customerService.deleteData(Integer.parseInt(id));
    //         redirectAttributes.addFlashAttribute("success", "Data berhasil dihapus!");

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    //     return "redirect:/pelanggan";
    // }
}
