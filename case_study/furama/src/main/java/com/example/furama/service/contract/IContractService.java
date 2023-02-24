package com.example.furama.service.contract;

import com.example.furama.dto.customer.ContractDto1;
import com.example.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllContract(Pageable pageable);

    void save(Contract contract);

    Contract findById(int id);

    Double calculatorTotal(int id);

//    Page<ContractDto1> getAllContractDto1(Pageable pageable);

    List<ContractDto1> getAllContractDto11();
}
