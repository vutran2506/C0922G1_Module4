package com.example.luyen_tap.controller;

import com.example.luyen_tap.model.Student;
import com.example.luyen_tap.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("students",studentService.findAll());
        return "list";
    }
    @GetMapping("/student/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("mess","successfully deleted");
        return "redirect:/";
    }
    @GetMapping("/student/create")
        public String create(Model model){
        model.addAttribute("student",new Student());
                return "create";
    }
    @PostMapping("/student/save")
    public String save(Student student, RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess","successfully created");
        return "redirect:/";
    }
    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("student",studentService.findByiId(id));
        return "edit";
    }
    @PostMapping("/edit/save")
    public  String edit(Student student,RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess","successfully edited");
        return "redirect:/";
    }
    @GetMapping("/student/{id}/view")
    public String view(@PathVariable int id,Model model){

        model.addAttribute("students",studentService.findByiId(id));
        return "list";
    }
}
