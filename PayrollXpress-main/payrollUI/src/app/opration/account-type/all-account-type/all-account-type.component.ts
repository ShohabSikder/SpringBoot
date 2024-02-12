import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AccountTypeService } from 'src/app/services/account-type.service';

@Component({
  selector: 'app-all-account-type',
  templateUrl: './all-account-type.component.html',
  styleUrls: ['./all-account-type.component.css']
})
export class AllAccountTypeComponent {
  constructor( 
    private accountTypeService : AccountTypeService,
    private router:Router
    ){}

    accountTypeList?: any;
  
    ngOnInit(){
    this.accountTypeList = this.accountTypeService.getAllAccountType();
    }

   
    deleteAccountType(id: number){
      this.accountTypeService.deleteAccountTypeById(id).subscribe(
        data=>{alert('Account Type successfully deleted!!'); 
          this.ngOnInit(); 
        },
        error=>alert('Somethig wrong, please try again!!')      
        );         
    }

   
    updateAccountType(id: number){
      this.router.navigate(['updateAccountType/',id]);
    }
}
