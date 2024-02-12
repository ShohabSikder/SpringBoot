package com.roman.payroll.serviceImpl;

import com.roman.payroll.entity.AccountType;
import com.roman.payroll.repository.IAccountTypeRepo;
import com.roman.payroll.service.AccountTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {

    private IAccountTypeRepo iAccountTypeRepo;

    public  void  saveAccountType(AccountType a){
        iAccountTypeRepo.save(a);
    }

    public void deleteAccountTypeById(int aid){
        iAccountTypeRepo.deleteById(aid);
    }

    public List<AccountType> getAllAccountType(){
        return iAccountTypeRepo.findAll();
    }

    public  AccountType findAccountTypeById(int aid){
        return iAccountTypeRepo.findById(aid).get();
    }
    public void update(AccountType a, int id){
        iAccountTypeRepo.save(a);
    }
}
