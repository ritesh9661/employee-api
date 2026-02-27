package com.freelance.employeeapi.service;

import com.freelance.employeeapi.dto.EmployeeDTO;
import com.freelance.employeeapi.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Employee addEmployee(EmployeeDTO dto);
    Page<Employee> getAllEmployees(int page,
                                   int size,
                                   String sortBy);
}
