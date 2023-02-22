package com.example.furama.service.contract.impl;

import com.example.furama.dto.customer.AttachFacilityDto;
import com.example.furama.model.contract.AttachFacility;
import com.example.furama.repository.contract.IAttachFacilityRepository;
import com.example.furama.service.contract.IAttachFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findAllById(int id) {
        return attachFacilityRepository.findById(id).get();
    }

    @Override
    public List<AttachFacility> getAttachFacility(int id) {
      return attachFacilityRepository.getAttachFacility(id);
    }

    @Override
    public List<AttachFacilityDto> getAttachFacilityDto(int id) {
        List<AttachFacility> attachFacilityList = attachFacilityRepository.getAttachFacility(id);
        List<AttachFacilityDto> attachFacilityDtoList = new ArrayList<>();
        for (AttachFacility attachFacilityX : attachFacilityList) {
            AttachFacilityDto attachFacilityDto = new AttachFacilityDto();
            BeanUtils.copyProperties(attachFacilityX, attachFacilityDto);
            attachFacilityDto.setQuantity(attachFacilityRepository.getQuantity(attachFacilityX.getId(), id));
            attachFacilityDto.setTotal(attachFacilityDto.getCost() * attachFacilityDto.getQuantity());
            attachFacilityDtoList.add(attachFacilityDto);
        }
        return attachFacilityDtoList;
    }
}
