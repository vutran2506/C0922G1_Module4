package com.example.furama.dto.customer;

import com.example.furama.model.contract.AttachFacility;
import com.example.furama.model.contract.Contract;

public class ContractDetailDto{

    private Contract contract;

    private int quantity;
    private AttachFacility attachFacility;

    public Contract getContract() {
        return contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
