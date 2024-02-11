package com.shohab.CreateApi.controller;


import com.shohab.CreateApi.model.Advance;
import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.model.Salary;
import com.shohab.CreateApi.repository.AdvanceRepository;
import com.shohab.CreateApi.repository.EmployeeRepository;
import com.shohab.CreateApi.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {


    @Autowired
    private AdvanceRepository advanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryService salaryService;



    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee saved successfully.");
    }


    @PostMapping("/saveAdvance")
    public ResponseEntity<String> saveAdvance(@RequestBody Advance request) {
        String employeeName = request.getEmployee().getName();
        BigDecimal amount = request.getAmount();

        // Fetch the employee from the repository based on the provided name
        Optional<Employee> optionalEmployee = employeeRepository.findByName(employeeName);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee not found");
        }
        Employee employee = optionalEmployee.get();

        // Create and save the Advance for the Employee
        Advance advance = new Advance();
        advance.setEmployee(employee);
        advance.setAmount(amount);
        advanceRepository.save(advance);

        return ResponseEntity.ok("Advance saved successfully.");
    }


    @PostMapping("/pay")
    public ResponseEntity<String> paySalary(@RequestBody Salary salaryPayment) {
        // Fetch the employee from the repository based on the provided ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(salaryPayment.getId());
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee not found");
        }
        Employee employee = optionalEmployee.get();

        // Check if the employee has taken an advance
        if (salaryService.hasTakenAdvance(employee)) {
            return ResponseEntity.badRequest().body("Employee has taken an advance.");
        }

        // Process salary payment
        // Your code to pay salary goes here

        return ResponseEntity.ok("Salary paid successfully.");
    }





}
