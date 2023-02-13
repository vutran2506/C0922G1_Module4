package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MailController {
    private  static  final  String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private static Matcher matcher;
    public MailController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
  @GetMapping("/home")
  public String showForm(){
      return "home";
  }
  @PostMapping("/validate")
  public String validateEmial(@RequestParam String email, Model model){
      boolean isValid = this.validate(email);
      if (!isValid){
          model.addAttribute("message","Email is invalid");
          return "home";
      }
      model.addAttribute("email", email);
      return "home";
  }

    private  boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return  matcher.matches();
    }
}
