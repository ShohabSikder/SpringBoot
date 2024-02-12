import {Component, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../../services/employee.service";
import {BankAccountService} from "../../../services/bank-account.service";
import {AccountTypeService} from "../../../services/account-type.service";
import {SalaryGradeService} from "../../../services/salary-grade.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Employee} from "../../../model/employee.model";
import {Subject} from "rxjs";

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent{

  @ViewChild('addemp')addemp!:NgForm;
  constructor(
    private employeeService : EmployeeService,
    private bankAccountService : BankAccountService,
    private accountTypeService : AccountTypeService,
    private salaryGradeService : SalaryGradeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }
  e: Employee = new Employee();
  id: number = 0;
  bankAccountList:any;
  accountTypeList:any;
  salaryGradeList:any;

  ngOnInit() {
    this.employeeService.getAllEmployee();
    this.bankAccountList = this.bankAccountService.getAllBankAccount();
    this.accountTypeList = this.accountTypeService.getAllAccountType();
    this.salaryGradeList = this.salaryGradeService.getAllSalaryGrade();
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(
      data => {
        this.e = data;

        this.addemp.form.patchValue({
          id: this.e.id,
          name : this.e.name,
          // salaryGrade : this.e.salaryGrade,
          address : this.e.address,
          mobile : this.e.mobile,

        })
      }
    );
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

  Updateloyee(){
    this.accArr = this.addemp.value;
    this.fkArr.salaryGrade.id = this.addemp.value.salaryGrade;
    this.fkArr.bankAccount.id = this.addemp.value.bankAccountId;
    this.e = Object.assign(this.accArr, this.fkArr);
    this.submitted = true;
    this.employeeService.updateEmployee(this.id, this.e).subscribe(
      data =>alert('Employee Update successfull!!'),
      error => alert('Something is wrong, please try again!!')
    );
    this.ngOnInit();
    this.router.navigate(['/allemployee']);
  }
}
