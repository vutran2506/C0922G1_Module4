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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("/customer")
    public String getAllCustomers(
            @RequestParam(defaultValue = "") String nameSearch,
            @RequestParam(defaultValue = "") String emailSearch,
            @RequestParam(defaultValue = "0") int customerTypeSearch,
            Model model, @PageableDefault(size = 5, page = 0) Pageable pageable, CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        if (customerTypeSearch ==0){
            model.addAttribute("customerList",customerService.searchCustomerNameAndEmail(nameSearch,emailSearch,pageable));
        }else {
            model.addAttribute("customerList",customerService.searchCustomer(nameSearch, emailSearch, customerTypeSearch, pageable)) ;
        }
        model.addAttribute("name", nameSearch);
        model.addAttribute("email", emailSearch);
        model.addAttribute("customerTypeSearch", customerTypeSearch);
        model.addAttribute("customerType", customerTypeService.getAll());
        model.addAttribute("customer", new CustomerDto());
        redirectAttributes.addFlashAttribute("mess","Danh sách khách hàng cần tìm");
        return "/customer/list";
    }

    @PostMapping("/saveCustomer")
    public String save(CustomerDto customerDto, RedirectAttributes requestAttributes) {
        List<Customer> list = customerService.
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        requestAttributes.addFlashAttribute("mess", "SuccessFully created");
        return "redirect:/customer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            redirectAttributes.addFlashAttribute("mess", "Khách Hàng Không Tồn Tại");
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Khách Hàng Đã Được Xoá Thành Công");
        return "redirect:/customer";

    }

//    @GetMapping("/searchCustomer")
//    public String searchCustomer(@RequestParam(defaultValue = "") String nameSearch,
//                                 @RequestParam(defaultValue = "") String emailSearch,
//                                 @RequestParam(defaultValue = "") String customerTypeSearch,
//                                 RedirectAttributes redirectAttributes,
//                                 @PageableDefault(size = 3, page = 0) Pageable pageable, Model model){
//      model.addAttribute("customerList",customerService.searchCustomer(nameSearch, emailSearch, customerTypeSearch, pageable)) ;
//        model.addAttribute("customerType", customerTypeService.getAll());
//       redirectAttributes.addFlashAttribute("mess","Danh sách khách hàng cần tìm");
//       return "/customer/list";
//    }

    @PostMapping("/updateCustomer")
    public String update(CustomerDto customerDto, RedirectAttributes requestAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        requestAttributes.addFlashAttribute("mess", "SuccessFully update");
        return "redirect:/customer";
    }

}
