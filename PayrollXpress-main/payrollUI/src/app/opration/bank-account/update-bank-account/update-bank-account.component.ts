import {Component, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {BankAccountService} from "../../../services/bank-account.service";
import {AccountTypeService} from "../../../services/account-type.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BankAccount} from "../../../model/bank-account.model";

@Component({
  selector: 'app-update-bank-account',
  templateUrl: './update-bank-account.component.html',
  styleUrls: ['./update-bank-account.component.css']
})
export class UpdateBankAccountComponent {

  @ViewChild('addacc')addacc!:NgForm;
  constructor(
    private bankAccountService : BankAccountService,
    private accountTypeService : AccountTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }
  ba: BankAccount = new BankAccount();
  id: number = 0;
  accountTypeList:any;

  ngOnInit() {
    this.bankAccountService.getAllBankAccount();
    this.accountTypeList = this.accountTypeService.getAllAccountType();
    this.id = this.route.snapshot.params['id'];
    this.bankAccountService.getBankAccountById(this.id).subscribe(
      data => {
        this.ba = data;

        this.addacc.form.patchValue({
          id: this.ba.id,
          account_name : this.ba.account_name,
          account_number : this.ba.account_number,
          current_balance : this.ba.current_balance,
          bank_and_branch_name : this.ba.bank_and_branch_name

        })
      }
    );
  }

  accArr:any;

  fkArr={
    "accountType":{
      "id":""
    }
  }

  submitted=false;

  updateBankAccount(){
    this.accArr = this.addacc.value;
    this.fkArr.accountType.id = this.addacc.value.accountTypeId;
    this.ba = Object.assign(this.accArr, this.fkArr);
    this.submitted = true;
    console.log(this.ba)
    this.bankAccountService.updateBankAccount(this.id,this.ba).subscribe(
      data => alert('Bank Account Update successfull!!'),
      error => alert('Something is wrong, please try again!!')
    );
    this.ngOnInit();
    this.router.navigate(['/allaccout']);
  }
}
