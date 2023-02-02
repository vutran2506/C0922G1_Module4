package com.example.controller;

import com.example.model.Settings;
import com.example.service.ISettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {
    @Autowired
    ISettingService settingService;

    @ModelAttribute("languages")
    public String[] arrayLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public String[] arrayPageSize() {
        return new String[]{"5", "10", "15", "25", "50", "100"};
    }

    @GetMapping("list")
    public String showList(Model model) {
        model.addAttribute("listSetting", settingService.findAll());
        return "list";
    }


    @GetMapping("update/{id}")
    public String showSetting(@PathVariable("id") int id, Model model) {
        Settings settings1 = settingService.findById(id);
        model.addAttribute("setting", settings1);
//        model.addAttribute("setting1", new Settings());
        return "home";
    }


    @PostMapping("/newUpdate")
    public String save(@ModelAttribute("setting") Settings setting, RedirectAttributes redirectAttributes) {
        settingService.update(setting);
        return "redirect: list";
    }
}
