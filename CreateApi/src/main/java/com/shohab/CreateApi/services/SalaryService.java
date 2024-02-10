package com.shohab.CreateApi.services;


import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.repository.AdvanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private  AdvanceRepository advanceRepository;

    public boolean hasTakenAdvance(Employee employee) {
        return advanceRepository.findByEmployee(employee).isPresent();
    }
}
