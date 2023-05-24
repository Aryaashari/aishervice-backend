package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class LaporanController {
    
    @GetMapping("/laporan")
    public String laporan(Model model){
        model.addAttribute("currentPage", "laporan");
        return "laporan";
    }
}
