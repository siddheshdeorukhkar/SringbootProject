package com.example.FirstSpring.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException (String message){
        super(message);
    }
}
