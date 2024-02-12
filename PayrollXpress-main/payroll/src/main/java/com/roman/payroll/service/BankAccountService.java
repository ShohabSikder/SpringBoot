package com.roman.payroll.service;

import com.roman.payroll.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    void  saveBankAccount(BankAccount b);

    void deleteBankAccountById(int bid);

    List<BankAccount> getAllBankAccount();

    BankAccount findBankAccountById(int bid);
    void update(BankAccount b, int id);
}
