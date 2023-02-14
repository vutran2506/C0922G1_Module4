package com.example.practice.controller;

import com.example.practice.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/")
    public String showFormLogin(@CookieValue(value = "SetUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "/login";

    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute User user, Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("123456")) {
            if (user.getEmail() != null)
                setUser = user.getEmail();
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie cook : cookies) {
                if (cook.getName().equals("setUser")) {
                    model.addAttribute("cookeValue", cook);
                    break;
                } else {
                    cook.setValue("");
                    model.addAttribute("cookieValue", cook);
                    break;
                }
            }
            model.addAttribute("mess", "Login Success . Welcome");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("mess", "Login Fail. Try again");
        }
        return "/login";
    }
}
