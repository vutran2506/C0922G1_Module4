package com.example.exercise_optional.controller;

import com.example.exercise_optional.model.Category;
import com.example.exercise_optional.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class CategoryController {

    @Autowired
    private  ICategoryService categoryService;

    @GetMapping("/category")
    public String showList(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        return "/category/list";
    }
    @GetMapping("/category/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess","successfully deleted");
        return "redirect:/category";
    }
    @GetMapping("/category/create")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "/category/create";
    }
    @PostMapping("/category/save")
    public String save(Category category,RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","successfully create or updated");
        return "redirect:/category";
    }
    @GetMapping("/category/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "/category/edit";
    }
}
