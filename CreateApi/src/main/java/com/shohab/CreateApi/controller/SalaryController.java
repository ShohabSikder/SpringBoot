package com.shohab.CreateApi.controller;


import com.shohab.CreateApi.model.Advance;
import com.shohab.CreateApi.model.Bonus;
import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.model.Salary;
import com.shohab.CreateApi.repository.AdvanceRepository;
import com.shohab.CreateApi.repository.BonusRepository;
import com.shohab.CreateApi.repository.EmployeeRepository;
import com.shohab.CreateApi.repository.SalaryRepository;
import com.shohab.CreateApi.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {


    @Autowired
    private AdvanceRepository advanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    public SalaryRepository salaryRepository;

    @Autowired
    public BonusRepository bonusRepository;



    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee saved successfully.");
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }



//    @PostMapping("/saveAdvance")
//    public ResponseEntity<String> saveAdvance(@RequestBody Advance request) {
//        String employeeName = request.getEmployee().getName();
//        BigDecimal amount = request.getAmount();
//
//        // Fetch the employee from the repository based on the provided name
//        Optional<Employee> optionalEmployee = employeeRepository.findByName(employeeName);
//        if (optionalEmployee.isEmpty()) {
//            return ResponseEntity.badRequest().body("Employee not found");
//        }
//        Employee employee = optionalEmployee.get();
//
//        // Create and save the Advance for the Employee
//        Advance advance = new Advance();
//        advance.setEmployee(employee);
//        advance.setAmount(amount);
//        advanceRepository.save(advance);
//
//        return ResponseEntity.ok("Advance saved successfully.");
//    }

//    @PostMapping("/saveAdvance")
//    public ResponseEntity<String> saveAdvance(@RequestBody Advance request) {
//        String employeeName = request.getEmployee().getName();
//        BigDecimal amount = request.getAmount();
//        Long employeeId = request.getEmployee().getId();
//
//        // Fetch all employees with the provided name
//        List<Employee> employees = employeeRepository.findByName(employeeName);
//
//        // Check if no employee found or multiple employees found with the same name
//        if (employees.isEmpty()) {
//            return ResponseEntity.badRequest().body("Employee not found");
//        }
////        else if (employees.size() > 1) {
////            return ResponseEntity.badRequest().body("Multiple employees found with the same name");
////        }
//        else if (employees.size() > 1) {
//            // Retrieve names of the multiple employees
//            List<String> employeeNames = employees.stream()
//                    .map(Employee::getName)
//                    .collect(Collectors.toList());
//            String errorMessage = "Multiple employees found with the same name: " + String.join(", ", employeeNames);
//            return ResponseEntity.badRequest().body(errorMessage);
//        }
//
//        // Retrieve the first (and only) employee with the provided name
//        Employee employee = employees.get(0);
//
//        // Create and save the Advance for the Employee
//        Advance advance = new Advance();
//        advance.setEmployee(employee);
//        advance.setAmount(amount);
//        advanceRepository.save(advance);
//
//        return ResponseEntity.ok("Advance saved successfully.");
//    }


    @PostMapping("/saveAdvance")
    public ResponseEntity<String> saveAdvance(@RequestBody Advance request) {
        String employeeName = request.getEmployee().getName();
        BigDecimal amount = request.getAmount();
        Long employeeId = request.getEmployee().getId(); // New parameter for specifying employee ID

        // Fetch the employee by ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee not found");
        }
        Employee employee = optionalEmployee.get();

        // Check if the employee name matches the provided name
        if (!employee.getName().equals(employeeName)) {
            return ResponseEntity.badRequest().body("Employee name does not match the provided ID");
        }

        // Create and save the Advance for the Employee
        Advance advance = new Advance();
        advance.setEmployee(employee);
        advance.setAmount(amount);
        advanceRepository.save(advance);

        return ResponseEntity.ok("Advance saved successfully.");
    }

    //Save Bonus
    @PostMapping("/saveBonus")
    public ResponseEntity<String> saveBonus(@RequestBody Bonus request) {
        String employeeName = request.getEmployee().getName();
        BigDecimal amount = request.getAmount();
        Long employeeId = request.getEmployee().getId(); // New parameter for specifying employee ID

        // Fetch the employee by ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee not found");
        }
        Employee employee = optionalEmployee.get();

        // Check if the employee name matches the provided name
        if (!employee.getName().equals(employeeName)) {
            return ResponseEntity.badRequest().body("Employee name does not match the provided ID");
        }

        // Create and save the Bonus for the Employee
        Bonus bonus = new Bonus();
        bonus.setEmployee(employee);
        bonus.setAmount(amount);
        bonusRepository.save(bonus);

        return ResponseEntity.ok("Bonus saved successfully.");
    }
    //All bonus List
    @GetMapping("/getAllBonus")
    public ResponseEntity<List<Bonus>> getAllBonus() {
        List<Bonus> advances = bonusRepository.findAll();
        return ResponseEntity.ok(advances);
    }




    @GetMapping("/getAllAdvance")
    public ResponseEntity<List<Advance>> getAllAdvance() {
        List<Advance> advances = advanceRepository.findAll();
        return ResponseEntity.ok(advances);
    }




//    @PostMapping("/pay")
//    public ResponseEntity<String> paySalary(@RequestBody Salary salaryPayment) {
//        // Fetch the employee from the repository based on the provided ID
//        List<Employee> optionalEmployee = employeeRepository.findByName(salaryPayment.getEmployee().getName());
//        if (optionalEmployee.isEmpty()) {
//            return ResponseEntity.badRequest().body("Employee not found");
//        }
//        Employee employee = optionalEmployee.get(0);
//
//        // Check if the employee has taken an advance
//        if (salaryService.hasTakenAdvance(employee)) {
//            BigDecimal advanceAmount = salaryService.getAdvanceAmount(employee);
//            return ResponseEntity.badRequest().body("Employee has taken an advance."+advanceAmount);
//        }
//
//        // Process salary payment
//        // Your code to pay salary goes here
//
//        return ResponseEntity.ok("Salary paid successfully.");
//    }

    @PostMapping("/pay")
    public ResponseEntity<String> paySalary(@RequestBody Salary salaryPayment) {
        String employeeName = salaryPayment.getEmployee().getName();
//        BigDecimal salaryAmount = salaryPayment.getAmount();
        Long employeeId = salaryPayment.getEmployee().getId(); // New parameter for specifying employee ID

        // Fetch the employee by ID
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee not found");
        }
        Employee employee = optionalEmployee.get();

        // Check if the employee name matches the provided name
        if (!employee.getName().equals(employeeName)) {
            return ResponseEntity.badRequest().body("Employee name does not match the provided ID");
        }

        // Check if the employee has taken an advance
        if (salaryService.hasTakenAdvance(employee)) {
            BigDecimal advanceAmount = salaryService.getAdvanceAmount(employee);
            // Check if the employee has also taken a bonus
            if (salaryService.hasTakenBonus(employee)) {
                BigDecimal bonusAmount = salaryService.getBonusAmount(employee);
                return ResponseEntity.badRequest().body("Employee has taken both an advance and a bonus. Advance amount: " + advanceAmount + ", Bonus amount: " + bonusAmount);
            } else {
                return ResponseEntity.badRequest().body("Employee has taken an advance. Advance amount: " + advanceAmount);
            }
        } else if (salaryService.hasTakenBonus(employee)) {
            BigDecimal bonusAmount = salaryService.getBonusAmount(employee);
            return ResponseEntity.badRequest().body("Employee has taken a bonus. Bonus amount: " + bonusAmount);
        }

        // Process salary payment
        // Your code to pay salary goes here

        return ResponseEntity.ok("Salary paid successfully.");
    }


    @GetMapping("/getAllSalaries")
    public ResponseEntity<List<Salary>> getAllSalaries() {
        List<Salary> salaries = salaryRepository.findAll();
        return ResponseEntity.ok(salaries);
    }






}
