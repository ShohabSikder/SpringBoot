package com.shohab.CreateApi.controller;


import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.model.Salary;
import com.shohab.CreateApi.repository.EmployeeRepository;
import com.shohab.CreateApi.repository.SalaryRepository;
import com.shohab.CreateApi.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salaries")
@CrossOrigin("*")
public class SalaryRestController {


    @Autowired
    public SalaryRepository salaryRepository;
//    @Autowired
//    public BonusRepository bonusRepository;
//    @Autowired
//    private AdvanceRepository advanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SalaryService salaryService;



//This is rough of saving advance of an employee
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





   //This method will show how much took advance and got bonus and calculated final salary
    @PostMapping("/pay")
    public ResponseEntity<String> paySalary(@RequestBody Salary salaryPayment) {
        String employeeName = salaryPayment.getEmployee().getName();
        Long employeeId = salaryPayment.getEmployee().getId();

        // Fetch the employee by ID or name. Here i used findByName method for getting employee name.
        // if i want to unique result from this, i hava to use findById method
        Optional<Employee> optionalEmployee = employeeRepository.findByName(employeeName);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("Employee not found");
        }


        //This section is created for getting employee by fetching by employee name.
        Employee employee = optionalEmployee.get();
        employee = employeeRepository.save(employee);
        salaryPayment.setEmployee(employee);

        // Initialize final salary as the original salary amount
        BigDecimal finalSalary = salaryPayment.getAmount();

        StringBuilder message = new StringBuilder();

        // Check if the employee has taken an advance
        if (salaryService.hasTakenAdvance(employee)) {
            BigDecimal advanceAmount = salaryService.getAdvanceAmount(employee);
            finalSalary = finalSalary.subtract(advanceAmount);
            message.append("Advance amount deducted: ").append(advanceAmount).append("\n");
        }

        // Check if the employee has taken a bonus
        if (salaryService.hasTakenBonus(employee)) {
            BigDecimal bonusAmount = salaryService.getBonusAmount(employee);
            finalSalary = finalSalary.add(bonusAmount);
            message.append("Bonus amount added: ").append(bonusAmount).append("\n");
        }

        // Save the final salary to the salaryPayment object
        salaryPayment.setAmount(finalSalary);

        // Save the salaryPayment object to the database
        salaryRepository.save(salaryPayment);

        // Process salary payment
        // Your code to pay salary goes here

        message.append("Final Salary calculated and paid successfully: ").append(finalSalary);


        return ResponseEntity.ok(message.toString());
    }

    @GetMapping("/getAllSalaries")
    public ResponseEntity<List<Salary>> getAllSalaries() {
        List<Salary> salaries = salaryRepository.findAll();
        return ResponseEntity.ok(salaries);
    }


    //This is rough of creating final salary
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


    //It will show how much took advance and get bonus an employee
//    @PostMapping("/pay")
//    public ResponseEntity<String> paySalary(@RequestBody Salary salaryPayment) {
//        String employeeName = salaryPayment.getEmployee().getName();
////        BigDecimal salaryAmount = salaryPayment.getAmount();
//        Long employeeId = salaryPayment.getEmployee().getId(); // New parameter for specifying employee ID
//
//        // Fetch the employee by ID
//        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
//        if (optionalEmployee.isEmpty()) {
//            return ResponseEntity.badRequest().body("Employee not found");
//        }
//        Employee employee = optionalEmployee.get();
//
//        // Check if the employee name matches the provided name
//        if (!employee.getName().equals(employeeName)) {
//            return ResponseEntity.badRequest().body("Employee name does not match the provided ID");
//        }
//
//        // Check if the employee has taken an advance
//        if (salaryService.hasTakenAdvance(employee)) {
//            BigDecimal advanceAmount = salaryService.getAdvanceAmount(employee);
//            // Check if the employee has also taken a bonus
//            if (salaryService.hasTakenBonus(employee)) {
//                BigDecimal bonusAmount = salaryService.getBonusAmount(employee);
//                return ResponseEntity.badRequest().body("Employee has taken both an advance and a bonus. Advance amount: " + advanceAmount + ", Bonus amount: " + bonusAmount);
//            } else {
//                return ResponseEntity.badRequest().body("Employee has taken an advance. Advance amount: " + advanceAmount);
//            }
//        } else if (salaryService.hasTakenBonus(employee)) {
//            BigDecimal bonusAmount = salaryService.getBonusAmount(employee);
//            return ResponseEntity.badRequest().body("Employee has taken a bonus. Bonus amount: " + bonusAmount);
//        }
//
//        // Process salary payment
//        // Your code to pay salary goes here
//
//        return ResponseEntity.ok("Salary paid successfully.");
//    }


    //It will calculate final salary an employee
//    @PostMapping("/pay")
//    public ResponseEntity<String> paySalary(@RequestBody Salary salaryPayment) {
//        String employeeName = salaryPayment.getEmployee().getName();
//        Long employeeId = salaryPayment.getEmployee().getId();
//
//        // Fetch the employee by ID
//        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
//        if (optionalEmployee.isEmpty()) {
//            return ResponseEntity.badRequest().body("Employee not found");
//        }
//        Employee employee = optionalEmployee.get();
//
//        // Check if the employee name matches the provided name
//        if (!employee.getName().equals(employeeName)) {
//            return ResponseEntity.badRequest().body("Employee name does not match the provided ID");
//        }
//
//        // Initialize final salary as the original salary amount
//        BigDecimal finalSalary = salaryPayment.getAmount();
//
//        StringBuilder message = new StringBuilder("Final Salary calculated and paid successfully: ").append(finalSalary);
//
//        // Check if the employee has taken an advance
//        if (salaryService.hasTakenAdvance(employee)) {
//            BigDecimal advanceAmount = salaryService.getAdvanceAmount(employee);
//            // Deduct advance amount from the final salary
//            finalSalary = finalSalary.subtract(advanceAmount);
//            message.append("\nAdvance amount deducted: ").append(advanceAmount);
//        }
//
//        // Check if the employee has taken a bonus
//        if (salaryService.hasTakenBonus(employee)) {
//            BigDecimal bonusAmount = salaryService.getBonusAmount(employee);
//            // Add bonus amount to the final salary
//            finalSalary = finalSalary.add(bonusAmount);
//            message.append("\nAdvance amount deducted: ").append(bonusAmount);
//        }
//
//        // Process salary payment
//        // Your code to pay salary goes here
//
//        return ResponseEntity.ok("Final Salary calculated and paid successfully: " + finalSalary);
//    }

}
