package com.example.furama.service.contract;

import com.example.furama.dto.customer.AttachFacilityDto;
import com.example.furama.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
    AttachFacility findAllById(int id);
    List<AttachFacility> getAttachFacility(int id);
    List<AttachFacilityDto> getAttachFacilityDto(int id);
}
