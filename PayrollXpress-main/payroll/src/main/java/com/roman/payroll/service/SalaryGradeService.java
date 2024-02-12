package com.roman.payroll.service;

import com.roman.payroll.entity.SalaryGrade;

import java.util.List;

public interface SalaryGradeService {

    void  saveSalaryGrade(SalaryGrade s);

    void deleteSalaryGradeById(int sid);

    List<SalaryGrade> getAllSalaryGrade();

    SalaryGrade findSalaryGradeById(int sid);

    void update(SalaryGrade sg, int id);

}
