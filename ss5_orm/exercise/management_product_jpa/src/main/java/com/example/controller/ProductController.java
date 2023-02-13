package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("product/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("mess", "successfully added new");
        return "redirect:/";
    }

    @GetMapping("product/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "successful deleted");
        return "redirect:/";
    }

    @GetMapping("product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("product/update")
    public String update( Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess", "successful updated");
        return "redirect:/";
    }

    @GetMapping("product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
    @GetMapping("/product/search")
    public  String search(String name,Model model){
        if(productService.findByNam(name).isEmpty()){
            model.addAttribute("mess","Not Find product");
        }
        model.addAttribute("products", productService.findByNam(name));

        return "list";
    }
}
