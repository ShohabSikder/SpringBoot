import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {BankAccount} from "../../../model/bank-account.model";
import {BankAccountService} from "../../../services/bank-account.service";
import {AccountTypeService} from "../../../services/account-type.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-add-bank-account',
  templateUrl: './add-bank-account.component.html',
  styleUrls: ['./add-bank-account.component.css']
})
export class AddBankAccountComponent implements OnInit{

  @ViewChild('addacc')addacc!:NgForm;
  constructor(
    private bankAccountService : BankAccountService,
    private accountTypeService : AccountTypeService,
    private router: Router
  ) { }
  ba: BankAccount = new BankAccount();

  accountTypeList:any;

  ngOnInit() {
    this.accountTypeList = this.accountTypeService.getAllAccountType();
    this.bankAccountService.getAllBankAccount();
  }

  accArr:any;

  fkArr={
    "accountType":{
      "id":""
    }
  }

  submitted=false;

  accountAdd(){
    this.accArr = this.addacc.value;
    this.fkArr.accountType.id = this.addacc.value.accountTypeId;
    this.ba = Object.assign(this.accArr, this.fkArr);
    this.submitted = true;
    this.bankAccountService.addBankAccount(this.ba).subscribe(
      data => alert('Bank Account added successfull!!'),
      error => alert('Something is wrong, please try again!!')
    );
    this.ngOnInit();
    this.router.navigate(['/allaccout']);
  }

}
