package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class PelangganController {
    
    @GetMapping("/pelanggan")
    public String pelanggan(Model model){
        model.addAttribute("currentPage", "pelanggan");
        return "pelanggan";
    }
}
