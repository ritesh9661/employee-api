package com.freelance.employeeapi.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private String name;
    private String email;
    private String department;
    private double salary;
}