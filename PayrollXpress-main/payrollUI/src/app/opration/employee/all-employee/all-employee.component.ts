import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {EmployeeService} from "../../../services/employee.service";

@Component({
  selector: 'app-all-employee',
  templateUrl: './all-employee.component.html',
  styleUrls: ['./all-employee.component.css']
})
export class AllEmployeeComponent implements OnInit{
  constructor(
    private employeeService : EmployeeService,
    private router:Router,
  ){}


  ngOnInit(){
    this.getAllEmployList();
  }

  empList: any;
  getAllEmployList(){
    this.employeeService.getAllEmployee().subscribe(
      data => {
        this.empList=data;
        // this.xxRoom = data;
        console.log(this.empList);

      }
    );
  }



  updateEmployee(id: number){
    this.router.navigate(['updatemployee/',id]);
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployeeById(id).subscribe(
      data=>{alert('Employee successfully deleted!!');
        this.ngOnInit();
      },
      error=>alert('Somethig wrong, please try again!!')
    );
    this.router.navigate(['/allemployee']);
  }
}
