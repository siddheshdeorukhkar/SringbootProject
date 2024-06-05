package com.example.FirstSpring;

import com.example.FirstSpring.entity.Address;
import com.example.FirstSpring.entity.Employee;
import com.example.FirstSpring.entity.Project;
import com.example.FirstSpring.entity.Spouse;
import com.example.FirstSpring.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(EmployeeService employeeService){
		return (args)->{
			Address address1 = new Address("Line 1", "Line 2", " ZipCode 1", "City 1", "State 1", "Country 1");
			Project project1= new Project("Name1", "Client Name1");
			Spouse spouse1= new Spouse("Name1", "Mobile1", 30);

			Employee employee = new Employee("Employee1", "City");
			employee.addProject(project1);
			employee.addAddress(address1);
			employee.setSpouse(spouse1);

			employeeService.createEmployee(employee);
			System.out.println("Getting an employee");
			Employee employee1= employeeService.getAnEmployee(1);


		};
	}
}
