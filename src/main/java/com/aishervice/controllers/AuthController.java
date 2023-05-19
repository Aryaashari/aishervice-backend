package com.aishervice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/login")
public class AuthController {
    
    @GetMapping
    public String login() {
        return "auth/login";
    }

}
