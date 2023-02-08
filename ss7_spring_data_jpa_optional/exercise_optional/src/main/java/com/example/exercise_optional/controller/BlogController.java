package com.example.exercise_optional.controller;


import com.example.exercise_optional.model.Blog;
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
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String showList(Model model,@RequestParam(required = false, defaultValue = "") String nameSearch,
                                 @PageableDefault(size = 2, page = 0, sort = "dateCreate", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Blog> blogPage = blogService.findByNam(nameSearch,pageable);
//        model.addAttribute("blogs", blogService.findAll());
        model.addAttribute("blogPage", blogPage);
        return "list";
    }

    @GetMapping("/blog/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "create";
    }

    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "successfully added new");
        return "redirect:/";
    }

    @GetMapping("/blog/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "successfully deleted");
        return "redirect:/";
    }
    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog",blogService.findById(id).get());
//        model.addAttribute("categoryList",categoryService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "edit";
    }

    @GetMapping("/blog/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id).get());
        return "view";
    }

}
