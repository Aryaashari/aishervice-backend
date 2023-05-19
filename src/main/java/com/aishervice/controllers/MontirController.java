package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MontirController {
    
    @GetMapping("/montir")
    public String montir(Model model){
        model.addAttribute("currentPage", "montir");
        return "montir";
    }
}
