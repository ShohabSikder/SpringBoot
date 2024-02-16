package com.shohab.CreateApi.controller;

import com.shohab.CreateApi.model.Advance;
import com.shohab.CreateApi.model.Bonus;
import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.repository.BonusRepository;
import com.shohab.CreateApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bonus")
@CrossOrigin("*")
public class BonusRestController {
    //Save Bonus
   @Autowired
   private BonusRepository bonusRepository;
   @Autowired
   private EmployeeRepository employeeRepository;




    @PostMapping("/saveBonus")
    public ResponseEntity<String> saveBonus(@RequestBody Bonus request) {
        String employeeName = request.getEmployee().getName();
        BigDecimal amount = request.getAmount();
        Long employeeId = request.getEmployee().getId(); // New parameter for specifying employee ID

        // Fetch the employee by ID
        Optional<Employee> optionalEmployee = employeeRepository.findByName(employeeName);
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



}
