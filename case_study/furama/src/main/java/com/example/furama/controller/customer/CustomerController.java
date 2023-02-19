package com.example.furama.controller.customer;

import com.example.furama.dto.customer.CustomerDto;
import com.example.furama.model.customer.Customer;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("/customer")
    public String getAllCustomers(Model model , @PageableDefault(size = 5, page = 0) Pageable pageable, CustomerDto customerDto){
        model.addAttribute("customerList", customerService.getAllCustomer(pageable));
        model.addAttribute("customerType", customerTypeService.getAll());
        model.addAttribute("customer",new CustomerDto());
        return "/customer/list";
    }
    @PostMapping("/save")
    public String save (CustomerDto customerDto, RedirectAttributes requestAttributes){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        requestAttributes.addFlashAttribute("mess","SuccessFully created");
        return "redirect:/customer";
    }
}
