package com.example.exercise_optional.controller;

import ch.qos.logback.core.pattern.color.BoldGreenCompositeConverter;
import com.example.exercise_optional.model.Blog;
import com.example.exercise_optional.model.Category;
import com.example.exercise_optional.service.IBlogService;
import com.example.exercise_optional.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private IBlogService blogService;

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
//    @GetMapping("/category/{id}/view")
//    public String view(@PathVariable int id,Model model,
//                       @PageableDefault(size = 2, page = 0,
//            sort = "dateCreate", direction = Sort.Direction.ASC) Pageable pageable){
//        Page<Blog> blogPage = blogService.findByCategory_Id(id,pageable);
//        Query thuần
//        Page<Blog> blogPage = blogService.search(id, pageable);

//        model.addAttribute("blogPage", blogPage);
//        model.addAttribute("idz", id);
//        return "list";
//    }
}
