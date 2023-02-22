package com.example.furama.service.contract.impl;

import com.example.furama.model.contract.ContractDetail;
import com.example.furama.repository.contract.IContractDetailRepository;
import com.example.furama.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
contractDetailRepository.save(contractDetail);
    }
}
