import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AllAccountTypeComponent } from './opration/account-type/all-account-type/all-account-type.component';
import { UpdateAccountTypeComponent } from './opration/account-type/update-account-type/update-account-type.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AllSalaryGradeComponent } from './opration/salary-grade/all-salary-grade/all-salary-grade.component';
import { UpdateSalaryGradeComponent } from './opration/salary-grade/update-salary-grade/update-salary-grade.component';
import { AddSalaryGradeComponent } from './opration/salary-grade/add-salary-grade/add-salary-grade.component';
import {AllEmployeeComponent} from "./opration/employee/all-employee/all-employee.component";
import { AddEmployeeComponent } from './opration/employee/add-employee/add-employee.component';
import {AddAccountTypeComponent} from "./opration/account-type/add-account-type/add-account-type.component";
import { AllBankAccountComponent } from './opration/bank-account/all-bank-account/all-bank-account.component';
import { AddBankAccountComponent } from './opration/bank-account/add-bank-account/add-bank-account.component';
import { UpdateBankAccountComponent } from './opration/bank-account/update-bank-account/update-bank-account.component';
import { UpdateEmployeeComponent } from './opration/employee/update-employee/update-employee.component';
import { LogInComponent } from './log-in/log-in.component';
import { RegisterComponent } from './register/register.component';
import { AdminPanelComponent } from './opration/admin-panel/admin-panel.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    AppComponent,
    AllAccountTypeComponent,
    UpdateAccountTypeComponent,
    HeaderComponent,
    AllSalaryGradeComponent,
    UpdateSalaryGradeComponent,
    AddSalaryGradeComponent,
    AllEmployeeComponent,
    AddEmployeeComponent,
    AddAccountTypeComponent,
    AllBankAccountComponent,
    AddBankAccountComponent,
    UpdateBankAccountComponent,
    UpdateEmployeeComponent,
    LogInComponent,
    RegisterComponent,
    AdminPanelComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatToolbarModule,
    MatSnackBarModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
