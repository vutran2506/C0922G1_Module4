package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Conversion {
    private final double CHANGE_RATE = 23000;
    @GetMapping("")
public  String showForm(){
        return "home";
    }
@PostMapping("/conversion")
    public ModelAndView conversionUsdToVnd(@RequestParam double usd){
        double vnd = usd*CHANGE_RATE;
        ModelAndView modelAndView = new ModelAndView("home","vnd",vnd);
        return modelAndView;
}
}
