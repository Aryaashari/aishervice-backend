package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ServiceController {
    
    @GetMapping("/service")
    public String service(Model model){
        model.addAttribute("currentPage", "service");
        return "service";
    }
}
