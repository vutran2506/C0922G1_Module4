package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;

    @ModelAttribute("languages")
    public String[] arrayLanguages() {
        return new String[]{"Java", "PHP", "C#", "C+"};
    }

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }

    @GetMapping("student/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("student/save")
    public String save(Student student) {
        student.setId((int) (Math.random() * 1000));
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("student/delete")
    public String delete(@RequestParam int id, Model model) {
        model.addAttribute("student", studentService.remove(id));
        return "redirect:/";
    }
}
