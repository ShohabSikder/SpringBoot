package com.shohab.CreateApi.services;


import com.shohab.CreateApi.model.Advance;
import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.repository.AdvanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private  AdvanceRepository advanceRepository;

    public boolean hasTakenAdvance(Employee employee) {
        // Assuming advanceRepository.findByEmployee(employee) returns a List<Advance>
        List<Advance> advances = advanceRepository.findByEmployee(employee);
        return !advances.isEmpty(); // Return true if advances list is not empty
    }
    public BigDecimal getAdvanceAmount(Employee employee) {
        // Assuming there's a method in your AdvanceRepository to find advances by employee
        List<Advance> advances = advanceRepository.findByEmployee(employee);
        BigDecimal totalAdvanceAmount = BigDecimal.ZERO; // Initialize total advance amount to zero

        for (Advance advance : advances) {
            totalAdvanceAmount = totalAdvanceAmount.add(advance.getAmount());
        }
        return totalAdvanceAmount;
    }










}
