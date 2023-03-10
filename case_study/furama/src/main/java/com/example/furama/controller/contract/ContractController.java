package com.example.furama.controller.contract;

import com.example.furama.dto.customer.ContractDetailDto;
import com.example.furama.dto.customer.ContractDto;
import com.example.furama.dto.customer.ContractDto1;
import com.example.furama.model.contract.AttachFacility;
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
import org.springframework.web.bind.annotation.*;
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
    ) {
        model.addAttribute("attractFacilityList", attachFacilityService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("contractList", contractService.findAllContract(pageable));
        model.addAttribute("contractDto1", new ContractDto1());
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
//        model.addAttribute("contractDto1", contractService.getAllContractDto1(pageable));
        model.addAttribute("contractDto1", contractService.getAllContractDto11());
        return "contract/list";
    }

    @PostMapping("contract/create")
    public String saveContract(ContractDto1 contractDto1, @RequestParam int[] listQuantity,
                               @RequestParam int[] listAttachFacility) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto1, contract);
        contractService.save(contract);
        addContractDetail(listQuantity,listAttachFacility,contract.getId());
        return "redirect:/contract";
    }

    @PostMapping("contract/addAttachFacility")
    public String saveAttachFacility(@ModelAttribute ContractDetailDto contractDetailDto) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
       contractDetailService.save(contractDetail);
        return"redirect:/contract";
    }
    public void addContractDetail(int[] listQuantity,int[]listAttachFacility , int contractId){

        for (int i = 0; i < listQuantity.length; i++) {
          Contract contract = contractService.findById(contractId);
            AttachFacility attachFacility = attachFacilityService.findAllById(listAttachFacility[i]);
            ContractDetail contractDetail = new ContractDetail(contract, attachFacility, listQuantity[i]);
            contractDetailService.save(contractDetail);
        }

    }
}
