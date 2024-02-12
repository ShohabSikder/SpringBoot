package com.roman.payroll.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @ManyToOne
    @JoinColumn(name = "account_type_fk")
    AccountType accountType;

    @Column(length = 60)
    String account_name;

    @Column(length = 60)
    String account_number;

    @Column(length = 60)
    double current_balance;

    @Column(length = 60)
    String bank_and_branch_name;

}
