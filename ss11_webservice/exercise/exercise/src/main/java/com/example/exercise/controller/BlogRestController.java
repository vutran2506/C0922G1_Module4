package com.example.exercise.controller;

import com.example.exercise.dto.BlogDto;
import com.example.exercise.dto.CategoryDto;
import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import com.example.exercise.service.IBlogService;
import com.example.exercise.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

//    Xem danh sách các blog
    @GetMapping("")
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

//    Xem chi tiết 1 bài viết
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getByBlog(@PathVariable int id) {
        if (blogService.findById(id)== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }

}
