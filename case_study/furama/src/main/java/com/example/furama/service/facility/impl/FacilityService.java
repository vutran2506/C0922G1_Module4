package com.example.furama.service.facility.impl;

import com.example.furama.model.facility.Facility;
import com.example.furama.repository.facility.IFacilityRepository;
import com.example.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> getAllFacility(String name, int facilityType, Pageable pageable) {
        return facilityRepository.findByNameContainingAndFacilityType_Id(name,facilityType,pageable);
    }

    @Override
    public Page<Facility> getAllByName(String name, Pageable pageable) {
        return facilityRepository.findByNameContaining(name,pageable);
    }

    @Override
    public void saveFacility(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public void deleteFacility(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
