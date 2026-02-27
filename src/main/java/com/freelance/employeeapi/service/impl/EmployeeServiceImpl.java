package com.freelance.employeeapi.service.impl;

import com.freelance.employeeapi.dto.EmployeeDTO;
import com.freelance.employeeapi.entity.Employee;
import com.freelance.employeeapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.freelance.employeeapi.service.EmployeeService;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl
        implements EmployeeService {

    private final EmployeeRepository repo;

    public Employee addEmployee(EmployeeDTO dto){

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());

        return repo.save(emp);
    }

    public Page<Employee> getAllEmployees(
            int page, int size, String sortBy){

        Pageable pageable =
                PageRequest.of(page, size,
                        Sort.by(sortBy));

        return repo.findAll(pageable);
    }
}
