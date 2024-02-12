package com.roman.payroll.repository;

import com.roman.payroll.entity.BankAccount;
import com.roman.payroll.entity.SalaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankAccountRepo extends JpaRepository<BankAccount, Integer> {
}
