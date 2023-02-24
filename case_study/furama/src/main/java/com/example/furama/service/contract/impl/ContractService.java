package com.example.furama.service.contract.impl;

import com.example.furama.dto.customer.ContractDto1;
import com.example.furama.model.contract.Contract;
import com.example.furama.repository.contract.IContractRepository;
import com.example.furama.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;


    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAllPageContract(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public Double calculatorTotal(int id) {
        return contractRepository.calculateTotal(id);
    }

    @Override
    public List<ContractDto1> getAllContractDto11() {
        List<Contract> contractList =contractRepository.findAll();
        List<ContractDto1> contractDto1List = new ArrayList<>();
         for (Contract ct :contractList){
             ContractDto1 contractDto1 = new ContractDto1();
             BeanUtils.copyProperties(ct,contractDto1);
             contractDto1.setTotal(contractRepository.calculateTotal(ct.getId()));
             contractDto1List.add(contractDto1);
         }

        return contractDto1List;
    }

//    @Override
//    public Page<ContractDto1> getAllContractDto1(Pageable pageable) {
//
//        Page<Contract> contractList = contractRepository.findAllPageContract(pageable);
//
//        Pageable newPage = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
//
//        List<Contract> contractList1 = contractList.getContent();
//
//        List<ContractDto1> contractDto1List = new ArrayList<>();
//
//        for (Contract contractX : contractList1) {
//            ContractDto1 contractDto1 = new ContractDto1();
//            BeanUtils.copyProperties(contractX, contractDto1);
//            contractDto1.setTotal(contractRepository.calculateTotal(contractX.getId()));
//            contractDto1List.add(contractDto1);
//        }
//        Page<ContractDto1> contractDto1Page = new PageImpl<>(contractDto1List,newPage,contractList.getTotalElements());
//        return contractDto1Page;
//    }
}
