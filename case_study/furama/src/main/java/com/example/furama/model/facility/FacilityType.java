package com.example.furama.model.facility;


import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255,nullable = false)
    private String name;

    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilitySet;

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
}
