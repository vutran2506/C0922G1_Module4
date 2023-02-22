package com.example.furama.service.facility;

import com.example.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IFacilityService {
    Page<Facility>getAllFacility(String name, int facilityType, Pageable pageable);
    Page<Facility>getAllByName(String name , Pageable pageable);
    void saveFacility(Facility facility);
    Facility findById(int id);
    void  deleteFacility(int id);
    List<Facility> findAll();
}
