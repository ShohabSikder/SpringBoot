package com.roman.payroll.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @Column(length = 60)
    int grade_name;

    @Column(length = 60)
    double basic_salary;

    @Column(length = 60)
    double house_rent;

    @Column(length = 60)
    double medical_allowance;

    @Column
    double total_salary;

}
