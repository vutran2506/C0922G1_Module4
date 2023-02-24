package com.example.furama.service.contract;

import com.example.furama.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();
    void save (ContractDetail contractDetail);
    ContractDetail findById(int id);
}
