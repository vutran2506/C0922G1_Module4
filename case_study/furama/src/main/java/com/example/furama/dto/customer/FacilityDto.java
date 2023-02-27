package com.example.furama.dto.customer;

import com.example.furama.model.contract.Contract;
import com.example.furama.model.facility.FacilityType;
import com.example.furama.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.lang.annotation.Annotation;
import java.util.Set;

public class FacilityDto implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255,nullable = false)
    private String name;
@Min(value = 0,message = "Diện tích phòng khônng được âm")
    @Column(nullable = false)
    private Integer area;
@Min(value = 0  , message = "Giá phòng không được âm")
    @Column(nullable = false)
    private Double cost;
@Min(value = 0, message = "Số người ở tối đa không được âm")
    @Column(nullable = false)
    private Double maxPeople;
    @Column(length = 255,nullable = false)
    private String standardRoom;
    @Column(length = 255,nullable = false)
    private String descriptionOtherConvenience;
    @Min(value = 0,message = "diện tích hồ bơi không được âm")
    @Column(nullable = false)
    private Double poolArea;

    @Min(value = 1, message = "Số tầng phải lớn hơn 1")
    @Column(nullable = false)
    private Integer numberOfFloor;
    @Column(length = 255,nullable = false)
    private String facilityFree;

    private RentType rentType;

    private FacilityType facilityType;

    private Set<Contract> contractSet;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, Integer area, Double cost, Double maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloor, String facilityFree, RentType rentType, FacilityType facilityType, Set<Contract> contractSet) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.contractSet = contractSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Double maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
