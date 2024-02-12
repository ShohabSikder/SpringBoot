package com.roman.payroll.service;

import com.roman.payroll.entity.AccountType;

import java.util.List;

public interface AccountTypeService {
    void  saveAccountType(AccountType a);

    void deleteAccountTypeById(int aid);

    List<AccountType> getAllAccountType();

    AccountType findAccountTypeById(int aid);

    void update(AccountType a, int id);
}
