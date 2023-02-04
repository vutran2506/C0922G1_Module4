package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("product/create")
    public String save(Product product) {
        product.setId((int) (Math.random() * 1000));
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("product/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("product/update")
    public String update(Product product) {
        productService.edit(product.getId(), product);
        return "redirect:/";
    }
    @GetMapping("product/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return"view";
    }
    @GetMapping("product/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("products",productService.findByName(name));
        return "list";
    }
}
