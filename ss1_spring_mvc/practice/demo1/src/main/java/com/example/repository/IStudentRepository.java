package com.example.repository;

import com.example.model.Student;


import java.util.List;
import java.util.Map;

public interface IStudentRepository {
    List<Student> findAll();
    void  save(Student student);
    void update(int id,Student student);
    void remove(int id);
    Student findById(int id);
    List<Student> findByName(String name);

}
