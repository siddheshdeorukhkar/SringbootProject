package com.example.FirstSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String clientName;

    @JsonIgnore
    @ManyToMany (mappedBy = "project")
    private List<Employee> employees;

    public Project(String name, String clientName, List<Employee> employees) {
        this.name = name;
        this.clientName = clientName;
        this.employees = employees;
    }

    public Project(String name, String clientName) {
        this.name = name;
        this.clientName = clientName;
    }



    public Project() {
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
