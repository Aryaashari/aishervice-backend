package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class KendaraanController {
    
    @GetMapping("/kendaraan")
    public String kendaraan(Model model){
        model.addAttribute("currentPage", "kendaraan");
        return "kendaraan";
    }
}
