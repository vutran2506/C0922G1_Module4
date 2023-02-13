package com.example.repository;

import com.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class StudentRepository implements IStudentRepository {
    static Map<Integer,Student> studentList;

    static {
        studentList = new HashMap<>();
     studentList.put(1,new Student(1,"Trần Ngọc Vũ",1, new String[]{"Java,JS"}));
     studentList.put(2,new Student(2,"Nguyễn Ngọc Hậu",1,new String[]{"Java,C#"}));
     studentList.put(3,new Student(3,"Bùi Đức Vũ",1,new String[]{"Java,C+"}));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList.values());
    }

    @Override
    public void save(Student student) {
        studentList.put(student.getId(),student);
    }

    @Override
    public void update(int id, Student student) {
studentList.put(id,student);
    }

    @Override
    public void remove(int id) {
studentList.remove(id);
    }

    @Override
    public Student findById(int id) {
        for (Student student:studentList.values()){
            if (id==student.getId()){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> list = new ArrayList<>();
        for (Student student: studentList.values()){
            if (student.getName().equals(name)){
                list.add(student);
            }
         return  list;
        }
        return null;
    }
}
