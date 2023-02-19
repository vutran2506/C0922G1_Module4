package com.example.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
     @GetMapping("/")
    public String showFormHome(){
         return "home";
     }
}
