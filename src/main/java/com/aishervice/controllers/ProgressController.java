package com.aishervice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ProgressController {
    
    @GetMapping("/progress")
    public String progress(Model model){
        model.addAttribute("currentPage", "progress");
        return "progress";
    }
}
