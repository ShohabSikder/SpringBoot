package com.roman.payroll.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    int id = (int) ((9999 - 100 + 1) * Math.random() + 100);

    @Column(length = 60)
    String name;

    @ManyToOne
    @JoinColumn(name = "salary_grade_fk")
    SalaryGrade salaryGrade;

    @Column(length = 120)
    String address;

    @Column(length = 60)
    String mobile;

    @ManyToOne
    @JoinColumn(name = "bank_account_fk")
    BankAccount bankAccount;

}
