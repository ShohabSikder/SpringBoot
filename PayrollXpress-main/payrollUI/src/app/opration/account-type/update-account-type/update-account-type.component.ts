import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountType } from 'src/app/model/account-type.model';
import { AccountTypeService } from 'src/app/services/account-type.service';

@Component({
  selector: 'app-update-account-type',
  templateUrl: './update-account-type.component.html',
  styleUrls: ['./update-account-type.component.css']
})
export class UpdateAccountTypeComponent {

  id: number = 0;
  at: AccountType = new AccountType();

  constructor(private accountTypeService: AccountTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.accountTypeService.getAllAccountType();
    this.id = this.route.snapshot.params['id'];
    this.accountTypeService.getAccountTypeById(this.id).subscribe(
      data => {
        this.at = data;
      }
    );
  }

  accountTypeUpdate(){
    this.accountTypeService.updateAccountType(this.id, this.at).subscribe(
      data => alert('Account Type updated successfull!!'),
       error => alert('Something is wrong, please try again!!'));
    this.ngOnInit();
    this.router.navigate(['/allaccouttype']);
  }
}
