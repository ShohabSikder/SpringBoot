package com.roman.payroll.repository;

import com.roman.payroll.entity.Employee;
import com.roman.payroll.entity.SalaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
}
