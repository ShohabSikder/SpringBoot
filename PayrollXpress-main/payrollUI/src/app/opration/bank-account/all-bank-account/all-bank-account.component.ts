import { Component } from '@angular/core';
import {AccountTypeService} from "../../../services/account-type.service";
import {Router} from "@angular/router";
import {BankAccountService} from "../../../services/bank-account.service";

@Component({
  selector: 'app-all-bank-account',
  templateUrl: './all-bank-account.component.html',
  styleUrls: ['./all-bank-account.component.css']
})
export class AllBankAccountComponent {
  constructor(
    private bankAccountService : BankAccountService,
    private router:Router
  ){}

  accountList?: any;

  ngOnInit(){
    this.accountList = this.bankAccountService.getAllBankAccount();
  }


  deleteAccount(id: number){
    this.bankAccountService.deleteBankAccountById(id).subscribe(
      data=>{alert('Account successfully deleted!!');
        this.ngOnInit();
      },
      error=>alert('Somethig wrong, please try again!!')
    );
  }


  updateAccount(id: number){
    this.router.navigate(['updateAccount/',id]);
  }
}
