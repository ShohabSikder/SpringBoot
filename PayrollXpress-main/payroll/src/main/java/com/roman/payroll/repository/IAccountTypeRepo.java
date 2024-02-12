package com.roman.payroll.repository;

import com.roman.payroll.entity.AccountType;
import com.roman.payroll.entity.SalaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountTypeRepo extends JpaRepository<AccountType, Integer> {
}
