package com.example.furama.controller.contract;

import com.example.furama.dto.customer.AttachFacilityDto;
import com.example.furama.dto.customer.ContractDto1;

import com.example.furama.service.contract.IAttachFacilityService;
import com.example.furama.service.contract.IContractDetailService;
import com.example.furama.service.contract.IContractService;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RestContractController {
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

    @GetMapping("/contract/api")
    public ResponseEntity<List<ContractDto1>> getAllContract() {
       List<ContractDto1> contractDto1List =contractService.getAllContractDto1();
        if (contractDto1List.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractDto1List, HttpStatus.OK);
        }
    }

    @GetMapping("/contract/api/view/{id}")
    public ResponseEntity<List<AttachFacilityDto>> getAllAttachFacility(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        List<AttachFacilityDto> attachFacilityList = attachFacilityService.getAttachFacilityDto(id);
        if (attachFacilityList.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
        }
    }
}
