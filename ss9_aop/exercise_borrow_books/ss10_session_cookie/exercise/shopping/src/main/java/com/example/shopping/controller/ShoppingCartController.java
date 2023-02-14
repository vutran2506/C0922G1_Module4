package com.example.shopping.controller;

import com.example.shopping.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;


@Controller
public class ShoppingCartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping("/shopping-cart")
    public String showCart(@SessionAttribute Cart cart, Model model){
model.addAttribute("cart", cart);
return "/cart";
    }
}
