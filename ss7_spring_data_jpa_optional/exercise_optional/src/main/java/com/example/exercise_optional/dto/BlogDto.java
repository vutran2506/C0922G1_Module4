package com.example.exercise_optional.dto;

import com.example.exercise_optional.model.Category;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BlogDto {
    private int id;

    private String name;
    private String author;
    private String dateCreate;
    private String content;

    private Category category;



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BlogDto() {
    }

    public BlogDto(int id, String name, String author, String dateCreate, String content, Category category) {
        this.id = id;

        this.name = name;
        this.author = author;
        this.dateCreate = dateCreate;
        this.content = content;
        this.category = category;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
