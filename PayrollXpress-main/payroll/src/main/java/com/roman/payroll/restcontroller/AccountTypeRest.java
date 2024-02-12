package com.roman.payroll.restcontroller;

import com.roman.payroll.constants.Constants;
import com.roman.payroll.entity.AccountType;
import com.roman.payroll.serviceImpl.AccountTypeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(Constants.ACCOUNT_TYPE)
@AllArgsConstructor
public class AccountTypeRest {

    private AccountTypeServiceImpl ats;

    @PostMapping("/add")
    public void accountTypeSave(@RequestBody AccountType at){
        ats.saveAccountType(at);
    }

    @GetMapping("/all")
    public List<AccountType> allAccountType(){
        return ats.getAllAccountType();
    }


    @PutMapping("/update/{id}")
    public void updateAccountType(@RequestBody AccountType at ,@PathVariable("id")  Integer id){
        ats.update(at, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccountType(@PathVariable("id") int id){
        ats.deleteAccountTypeById(id);
    }

    @GetMapping("/{id}")
    public AccountType getAccountTypeById(@PathVariable("id") int id){;
        return ats.findAccountTypeById(id);
    }
}
