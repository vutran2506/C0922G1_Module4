package com.example.exersice.controller;



import com.example.exersice.model.Blog;
import com.example.exersice.service.impl.IBlogService;
import com.example.exersice.service.impl.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@CrossOrigin("*")
@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<Page<Blog>> getSearchList( @RequestParam(required = false, defaultValue = "") String name,
                                                     @RequestParam(required = false,defaultValue = "0") int page,
                                                     @RequestParam(required = false,defaultValue = "2") int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Blog> blogPage = blogService.findByName(name, pageable);
        if(blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blogPage,HttpStatus.OK);
        }

    }

}
