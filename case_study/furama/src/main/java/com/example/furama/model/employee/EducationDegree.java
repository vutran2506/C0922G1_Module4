package com.example.furama.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255,nullable = false)
    private String name;
    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employeeSet;

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
