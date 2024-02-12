package com.roman.payroll.restcontroller;

import com.roman.payroll.constants.Constants;
import com.roman.payroll.entity.BankAccount;
import com.roman.payroll.serviceImpl.BankAccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(Constants.BANK_ACCOUNT)
@AllArgsConstructor
public class BankAccountRest {

    private BankAccountServiceImpl bas;

    @PostMapping("/add")
    public void bankAccountSave(@RequestBody BankAccount ba){
        bas.saveBankAccount(ba);
    }

    @GetMapping("/all")
    public List<BankAccount> allBankAccount(){
        return bas.getAllBankAccount();
    }


    @PutMapping("/update/{id}")
    public void updateBankAccount(@RequestBody BankAccount b ,@PathVariable("id")  Integer id){
        bas.update(b, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBankAccount(@PathVariable("id") int id){
        bas.deleteBankAccountById(id);
    }

    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable("id") int id){;
        return bas.findBankAccountById(id);
    }
}
