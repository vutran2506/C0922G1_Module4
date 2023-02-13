package com.example.service;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
studentRepository.save(student);
    }

    @Override
    public void update(int id, Student student) {
        studentRepository.update(id,student);
    }

    @Override
    public Object remove(int id) {
studentRepository.remove(id);
        return null;
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
