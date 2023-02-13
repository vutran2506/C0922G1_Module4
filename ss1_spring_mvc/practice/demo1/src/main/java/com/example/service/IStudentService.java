package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void  save(Student student);
    void update(int id,Student student);
    Object remove(int id);
    Student findById(int id);
    List<Student> findByName(String name);

}
