package com.example.exercise_optional.controller;


import com.example.exercise_optional.dto.BlogDto;
import com.example.exercise_optional.model.Blog;
import com.example.exercise_optional.service.IBlogService;
import com.example.exercise_optional.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String showList( BlogDto blogDto,Model model,
                            @RequestParam( defaultValue = "") String nameSearch,
                           @RequestParam( defaultValue = "0")int categorySearch,
                           @PageableDefault(size = 2, page = 0, sort = "dateCreate",
                                   direction = Sort.Direction.ASC) Pageable pageable) {
        if (categorySearch==0){
            Page<Blog> blogPage = blogService.findByName(nameSearch, pageable);
            model.addAttribute("blogPage", blogPage);
        }else {
            Page<Blog> blogPage = blogService.findByCategory_IdAndName(nameSearch,categorySearch, pageable);
            model.addAttribute("blogPage", blogPage);
        }
        model.addAttribute("nameSearch",nameSearch);
        model.addAttribute("categorySearch",categorySearch);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog",new BlogDto());
        return "list";
    }

    @GetMapping("/blog/create")
    public String create(Model model) {
        model.addAttribute("blog", new BlogDto());
        model.addAttribute("categoryList", categoryService.findAll());
        return "create";
    }

    @PostMapping("/blog/save")
    public String save(@Validated BlogDto blogDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("blog", blogDto);
            return "create";
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
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
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
//        model.addAttribute("categoryList",categoryService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "edit";
    }

    @GetMapping("/blog/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

}
