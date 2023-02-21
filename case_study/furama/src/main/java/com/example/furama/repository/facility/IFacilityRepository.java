package com.example.furama.repository.facility;

import com.example.furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from Facility  where name like concat('%',:name,'%') and facility_type_id like concat('%',:facilityType,'%') ",nativeQuery = true)
    Page<Facility> findByNameContainingAndFacilityType_Id(@Param("name") String name, @Param("facilityType") String type, Pageable pageable);
//    Page<Facility> findByNameContainingAndFacilityType_Id(String name, String facilityType, Pageable pageable);
}
