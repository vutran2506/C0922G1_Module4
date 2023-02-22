package com.example.furama.service.contract.impl;

import com.example.furama.dto.customer.ContractDto1;
import com.example.furama.model.contract.Contract;
import com.example.furama.repository.contract.IContractRepository;
import com.example.furama.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        return contractRepository.findAll(pageable);
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
    public List<ContractDto1> getAllContractDto1() {
        List<Contract> contractList = contractRepository.findAll();
        List<ContractDto1> contractDto1List = new ArrayList<>();
        double totalMoney = 0;
        for (Contract contractX : contractList) {
            ContractDto1 contractDto1 = new ContractDto1();
            BeanUtils.copyProperties(contractX, contractDto1);
            contractDto1.setTotal(contractRepository.calculateTotal(contractX.getId()));
            totalMoney += contractDto1.getTotal();
            contractDto1List.add(contractDto1);
        }
        return contractDto1List;
    }
}
