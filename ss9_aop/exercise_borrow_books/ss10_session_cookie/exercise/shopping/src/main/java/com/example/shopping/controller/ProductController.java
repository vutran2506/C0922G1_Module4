package com.example.shopping.controller;

import com.example.shopping.model.Cart;
import com.example.shopping.model.Product;
import com.example.shopping.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "home";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/down/{id}")
    public String downToCart(@PathVariable long id,
                             @ModelAttribute Cart cart,
                             @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.downValue(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/shop/detail/{id}")
    public String showDetail(@PathVariable long id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("productId", id + "");
        cookie.setMaxAge(60 * 60 * 12);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }
}
