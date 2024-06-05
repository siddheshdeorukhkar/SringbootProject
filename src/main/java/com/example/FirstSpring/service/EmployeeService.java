package com.example.FirstSpring.service;

import com.example.FirstSpring.entity.Address;
import com.example.FirstSpring.entity.Employee;
import com.example.FirstSpring.exception.EmployeeNotFoundException;
import com.example.FirstSpring.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
//    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
//            new Employee(1, "Prathamesh", "Solapur"),
//            new Employee(2, "GaneshS", "Ambejogai"),
//            new Employee(3, "Nilesh", "Kolhapur"),
//            new Employee(4, "Dheeraj", "Nashik")
//    ));
    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> findAllEmployees() {
        //return employeeList;
        return  employeeRepository.findAll();
    }
    @Transactional
    public Employee getAnEmployee(int id){
//        return employeeList.stream()
//                .filter(e -> (e.getEmployeeId()) == id)
//                        .findFirst()
//                        .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " +id));
        return employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id "+ id));
    }
    @Transactional
    public void createEmployee (Employee employee){
       // employeeList.add(employee);
        ArrayList<Address>addressArrayList = new ArrayList<>();
        for (Address address: employee.getAddresses()){
            addressArrayList.add((new Address
                                                (address.getLine1(),
                                                address.getLine2(),
                                                address.getZipcode(),
                                                address.getCity(),
                                                address.getState(),
                                                address.getCountry(),
                                                                    employee)
            ));
        }
        employee.setAddresses(addressArrayList);
        employeeRepository.save(employee);
    }

    @Transactional
    public void updateEmployee(Employee employee){
//        List<Employee> tempEmployee = new ArrayList<>();
//        for (Employee emp: employeeList){
//            if(emp.getEmployeeId()==employee.getEmployeeId()){
//                emp.setEmployeeName(employee.getEmployeeName());
//                emp.setEmployeeCity(employee.getEmployeeCity());
//            }
//            tempEmployee.add(emp);
//        }
//        this.employeeList= tempEmployee;
        if(!employeeRepository.existsById(employee.getEmployeeId())){
            throw new EmployeeNotFoundException("Employee not found with id " + employee.getEmployeeId());
        }
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(int id){
//        ArrayList<Employee>tempEmployee = new ArrayList<>();
//        for(Employee emp: employeeList){
//            if(emp.getEmployeeId()==id)
//                continue;
//            tempEmployee.add(emp);
//        }
//        this.employeeList= tempEmployee;
        employeeRepository.deleteById(id);
        //


    }



}
