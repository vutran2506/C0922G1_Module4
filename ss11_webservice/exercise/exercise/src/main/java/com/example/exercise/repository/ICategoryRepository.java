package com.example.exercise.repository;

import com.example.exercise.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
