import {Component, ViewChild} from '@angular/core';
import {SalaryGradeService} from "../../../services/salary-grade.service";
import {Router} from "@angular/router";
import {EmployeeService} from "../../../services/employee.service";
import {NgForm} from "@angular/forms";
import {BankAccountService} from "../../../services/bank-account.service";
import {AccountTypeService} from "../../../services/account-type.service";
import {Employee} from "../../../model/employee.model";

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent {
  @ViewChild('addemp')addemp!:NgForm;
  constructor(
    private employeeService : EmployeeService,
    private bankAccountService : BankAccountService,
    private accountTypeService : AccountTypeService,
    private salaryGradeService : SalaryGradeService,
    private router: Router
  ) { }
  e: Employee = new Employee();

  bankAccountList:any;
  accountTypeList:any;
  salaryGradeList:any;

  ngOnInit() {
    this.employeeService.getAllEmployee();
    this.bankAccountList = this.bankAccountService.getAllBankAccount();
    this.accountTypeList = this.accountTypeService.getAllAccountType();
    this.salaryGradeList = this.salaryGradeService.getAllSalaryGrade();
  }

  accArr:any;

  fkArr={
    "salaryGrade":{
      "id":""
    },
    "bankAccount":{
      "id":""
    },
  }


  submitted=false;

  employeeAdd(){
    this.accArr = this.addemp.value;
    this.fkArr.salaryGrade.id = this.addemp.value.salaryGrade;
    this.fkArr.bankAccount.id = this.addemp.value.bankAccountId;
    this.e = Object.assign(this.accArr, this.fkArr);
    this.submitted = true;
    this.employeeService.addEmployee(this.e).subscribe(
      data => alert('Employee added successful!!'),
      error => alert('Something is wrong, please try again!!')
    );
    this.ngOnInit();
    this.router.navigate(['/allemployee']);

  }
}
