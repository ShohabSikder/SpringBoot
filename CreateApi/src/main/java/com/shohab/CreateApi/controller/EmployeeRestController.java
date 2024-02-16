package com.shohab.CreateApi.controller;

import com.shohab.CreateApi.model.Department;
import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.repository.EmployeeRepository;
import com.shohab.CreateApi.repository.IDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    IDepartmentRepo iDepartmentRepo;

//    @PostMapping("/saveEmployee")
//    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
//        employeeRepository.save(employee);
//        return ResponseEntity.ok("Employee saved successfully.");
//    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        String name=employee.getDepartment().getName();
        Department department = iDepartmentRepo.findByName(name);

        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(savedEmployee);

    }
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }
}
