package com.example.exercise_optional.dto;

import com.example.exercise_optional.model.Blog;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

public class CategoryDto {
    private int id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)

    Set<Blog> blogSet;

    public CategoryDto() {
    }

    public CategoryDto(int id, String name, Set<Blog> blogSet) {
        this.id = id;
        this.name = name;
        this.blogSet = blogSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String category) {
        this.name = category;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
