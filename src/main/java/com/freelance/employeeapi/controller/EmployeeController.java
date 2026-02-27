package com.freelance.employeeapi.controller;

import com.freelance.employeeapi.dto.EmployeeDTO;
import com.freelance.employeeapi.entity.Employee;
import com.freelance.employeeapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public Employee add(@RequestBody EmployeeDTO dto){
        return service.addEmployee(dto);
    }

    @GetMapping
    public Page<Employee> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy){

        return service.getAllEmployees(
                page,size,sortBy);
    }
}