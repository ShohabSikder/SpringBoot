import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { AccountType } from 'src/app/model/account-type.model';
import { AccountTypeService } from 'src/app/services/account-type.service';

@Component({
  selector: 'app-add-account-type',
  templateUrl: './add-account-type.component.html',
  styleUrls: ['./add-account-type.component.css']
})
export class AddAccountTypeComponent {

  at: AccountType = new AccountType();

  submitted=false;

  constructor(
    private accountTypeService : AccountTypeService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.accountTypeService.getAllAccountType();
  }

    accountTypeAdd(){
    this.submitted = true;
    this.accountTypeService.addAccountType(this.at).subscribe(
      data => alert('Account Type added successfull!!'),
       error => alert('Something is wrong, please try again!!')
    );
    this.ngOnInit();
    this.router.navigate(['/allaccouttype']);
  }
}
