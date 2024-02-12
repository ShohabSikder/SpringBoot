import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAccountTypeComponent } from './opration/account-type/add-account-type/add-account-type.component';
import { UpdateAccountTypeComponent } from './opration/account-type/update-account-type/update-account-type.component';
import { AllAccountTypeComponent } from './opration/account-type/all-account-type/all-account-type.component';
import { AllSalaryGradeComponent } from './opration/salary-grade/all-salary-grade/all-salary-grade.component';
import { UpdateSalaryGradeComponent } from './opration/salary-grade/update-salary-grade/update-salary-grade.component';
import { AddSalaryGradeComponent } from './opration/salary-grade/add-salary-grade/add-salary-grade.component';
import {AllEmployeeComponent} from "./opration/employee/all-employee/all-employee.component";
import {AddBankAccountComponent} from "./opration/bank-account/add-bank-account/add-bank-account.component";
import {AllBankAccountComponent} from "./opration/bank-account/all-bank-account/all-bank-account.component";
import {AddEmployeeComponent} from "./opration/employee/add-employee/add-employee.component";
import {UpdateEmployeeComponent} from "./opration/employee/update-employee/update-employee.component";
import {UpdateBankAccountComponent} from "./opration/bank-account/update-bank-account/update-bank-account.component";
import {LogInComponent} from "./log-in/log-in.component";
import {RegisterComponent} from "./register/register.component";
import {HeaderComponent} from "./header/header.component";
import {AdminPanelComponent} from "./opration/admin-panel/admin-panel.component";

const routes: Routes = [
  {path:'logInComponent', component:LogInComponent},
  {path:'registerComponent', component:RegisterComponent},

  {path:'adminPanelComponent', component:AdminPanelComponent},

  {path:'headerComponent', component:HeaderComponent},

  {path:'addaccount', component:AddBankAccountComponent},
  {path:'allaccout', component:AllBankAccountComponent},
  {path:'updateAccount/:id', component:UpdateBankAccountComponent},

  {path:'addaccounttype', component:AddAccountTypeComponent},
  {path:'allaccouttype', component:AllAccountTypeComponent},
  {path:'updateAccountType/:id', component:UpdateAccountTypeComponent},

  {path:'addsalarygrade/:id', component:AddSalaryGradeComponent},
  {path:'allsalarygrade', component:AllSalaryGradeComponent},
  {path:'updatesalarygrade/:id', component:UpdateSalaryGradeComponent},

  {path:'addemployee', component:AddEmployeeComponent},
  {path:'allemployee', component:AllEmployeeComponent},
  {path:'updatemployee/:id', component:UpdateEmployeeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
