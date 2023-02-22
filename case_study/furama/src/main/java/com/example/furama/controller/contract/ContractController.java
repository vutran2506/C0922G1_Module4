package com.example.furama.controller.contract;

import com.example.furama.dto.customer.ContractDto;
import com.example.furama.dto.customer.ContractDto1;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import com.example.furama.service.contract.IAttachFacilityService;
import com.example.furama.service.contract.IContractDetailService;
import com.example.furama.service.contract.IContractService;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("/contract")
    public String getAllController(Model model, Pageable pageable
                                   ){
        model.addAttribute("attractFacilityList",attachFacilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("contractList",contractService.findAllContract(pageable));
        model.addAttribute("contractDto",new ContractDto1());
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contractDto1", contractService.getAllContractDto1());
        return "contract/list";
    }

   @PostMapping("contract/create")
    public String saveContract(ContractDto1 contractDto1){
       Contract contract = new Contract();
       BeanUtils.copyProperties(contractDto1,contract);
       contractService.save(contract);
        return "redirect:/contract";
   }

    @GetMapping("/view/{id}")
    public String getAttachFacility(Model model, @PathVariable("id") int id) {
        model.addAttribute("attachFacilityList",attachFacilityService.findAllById(id));
        return "/contract/list";
    }
}
