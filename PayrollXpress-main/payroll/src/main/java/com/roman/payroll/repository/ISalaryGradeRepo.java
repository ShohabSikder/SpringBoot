package com.roman.payroll.repository;

import com.roman.payroll.entity.SalaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaryGradeRepo extends JpaRepository<SalaryGrade, Integer> {

    @Query("select count (salaryg) from SalaryGrade salaryg")
    public int salaryTlenth();


}
