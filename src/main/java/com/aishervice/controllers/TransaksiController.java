package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class TransaksiController {
    
    @GetMapping("/transaksi")
    public String transaksi(Model model){
        model.addAttribute("currentPage", "transaksi");
        return "transaksi";
    }
}
