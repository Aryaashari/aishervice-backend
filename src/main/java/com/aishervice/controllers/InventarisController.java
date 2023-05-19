package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class InventarisController {
    
    @GetMapping("/inventaris")
    public String inventaris(Model model){
        model.addAttribute("currentPage", "inventaris");
        return "inventaris";
    }
}
