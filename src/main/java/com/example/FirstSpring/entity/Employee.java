package com.example.FirstSpring.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int employeeId;
    String employeeName;
    String employeeCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name= "fk_spouse")
    private Spouse spouse;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Address>addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "employee_project",
            joinColumns= @JoinColumn(name= "fk_employee"),
            inverseJoinColumns = @JoinColumn(name = "fk_project"))

    private List<Project> project;
    public Employee(){
    }

    public Employee(String employeeName, String employeeCity, Spouse spouse, List<Address> addresses, List<Project> project) {
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
        this.spouse = spouse;
        this.addresses = addresses;
        this.project = project;
    }

    public Employee(String employeeName, String employeeCity) {
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void removeProject(Project project){
        this.project.remove(project);
        project.getEmployees().remove(project);
    }
    public void addProject(Project project){
        this.project.add(project);
        project.getEmployees().add(this);
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    public void addAddress(Address address){
        this.addresses = new ArrayList<>();
        this.addresses.add(address);
        address.setEmployee(this);
    }
    public void removeAddress(Address address){
        this.addresses.remove(address);
        address.setEmployee(null);
    }

}
