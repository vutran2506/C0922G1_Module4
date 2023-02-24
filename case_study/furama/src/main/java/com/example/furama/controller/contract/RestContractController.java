package com.example.furama.controller.contract;

import com.example.furama.dto.customer.AttachFacilityDto;
import com.example.furama.dto.customer.ContractDetailDto;
import com.example.furama.dto.customer.ContractDto1;

import com.example.furama.model.contract.ContractDetail;
import com.example.furama.service.contract.IAttachFacilityService;
import com.example.furama.service.contract.IContractDetailService;
import com.example.furama.service.contract.IContractService;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
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

//    @GetMapping("/contract/api")
//    public ResponseEntity<Page<ContractDto1>> getAllContract(@PageableDefault(size = 5, page = 0) Pageable pageable) {
//        Page<ContractDto1> contractDto1List = contractService.getAllContractDto1(pageable);
//        if (contractDto1List.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(contractDto1List, HttpStatus.OK);
//        }
//    }

    @GetMapping("/contract/api")
    public ResponseEntity<List<ContractDto1>> getAllContract() {
        List<ContractDto1> contractDto1List = contractService.getAllContractDto11();
        if (contractDto1List.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contractDto1List, HttpStatus.OK);
        }
    }

    @GetMapping("/contract/api/view/{id}")
    public ResponseEntity<List<AttachFacilityDto>> getAllAttachFacility(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        List<AttachFacilityDto> attachFacilityList = attachFacilityService.getAttachFacilityDto(id);
        if (attachFacilityList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
        }
    }

//    @PostMapping("/contract/api/contractDetail")
//    public ResponseEntity<ContractDetail> createContractDetail(@RequestBody ContractDetailDto contractDetailDto) {
////        ContractDetail contractDetail = new ContractDetail();
//        if ((contractDetailDto.getAttachFacility().getId())==(contractDetailService.findById(contractDetailDto.getContract().getId()).getAttachFacility().getId() )){
//            contractDetailDto.setQuantity(contractDetailDto.getQuantity() + contractDetailService.findById(contractDetailDto.getAttachFacility().getId()).getQuantity());
//        }
//
//BeanUtils.copyProperties(contractDetailDto,contractDetail );
//
//contractDetailService.save(contractDetail);
//        return  new ResponseEntity<>(HttpStatus.OK);
//
//    }
}