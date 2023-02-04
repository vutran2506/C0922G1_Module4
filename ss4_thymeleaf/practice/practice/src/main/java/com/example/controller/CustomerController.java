package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller

public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    @GetMapping("customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("customer/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random() * 1000));
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findByIdCustomer(id));
        return "edit";
    }

    @PostMapping("customer/update")
    public String update(Customer customer) {
        customerService.updateCustomer(customer.getId(), customer);
        return "redirect:/";
    }

    @GetMapping("customer/{id}/delete")
    public String deleteCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findByIdCustomer(id));
        return "delete";
    }
    @PostMapping("customer/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes){
        customerService.removeCustomer(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
    @GetMapping("customer/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findByIdCustomer(id));
        return "view";
    }
}
