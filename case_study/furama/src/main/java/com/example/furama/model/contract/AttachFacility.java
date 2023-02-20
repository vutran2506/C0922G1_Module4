package com.example.furama.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(length = 255,nullable = false)
    private double cost;
    @Column(length = 255,nullable = false)
    private String unit;
    @Column(length = 255,nullable = false)
    private String status;
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetailSet;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
