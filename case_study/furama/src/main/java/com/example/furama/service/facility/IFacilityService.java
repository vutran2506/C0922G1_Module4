package com.example.furama.service.facility;

import com.example.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IFacilityService {
    Page<Facility>getAllFacility(String name, String facilityType, Pageable pageable);
    void saveFacility(Facility facility);
    Facility findById(int id);
    void  deleteFacility(int id);
}
