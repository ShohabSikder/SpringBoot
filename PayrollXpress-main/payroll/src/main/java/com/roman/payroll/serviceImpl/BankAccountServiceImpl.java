package com.roman.payroll.serviceImpl;

import com.roman.payroll.entity.BankAccount;
import com.roman.payroll.repository.IBankAccountRepo;
import com.roman.payroll.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private IBankAccountRepo iBankAccountRepo;

    public  void  saveBankAccount(BankAccount b){
        iBankAccountRepo.save(b);
    }

    public void deleteBankAccountById(int bid){
        iBankAccountRepo.deleteById(bid);
    }

    public List<BankAccount> getAllBankAccount(){
        return iBankAccountRepo.findAll();
    }

    public  BankAccount findBankAccountById(int bid){
        return iBankAccountRepo.findById(bid).get();
    }
    public void update(BankAccount b, int id){
        iBankAccountRepo.save(b);
    }
}
