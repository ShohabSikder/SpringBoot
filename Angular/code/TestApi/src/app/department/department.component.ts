import { Component, OnInit } from '@angular/core';
import { Department } from '../model/department.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DepartmentService } from '../service/department.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrl: './department.component.css'
})
export class DepartmentComponent implements OnInit {
  department:Department=new Department();

  departmentData:any;
  formValue !: FormGroup;


constructor(private depService:DepartmentService, private formBuilder:FormBuilder){}

  ngOnInit(): void {

    this.formValue=this.formBuilder.group(
      {
        name:['']
      }
      
    );


    this.getAllDep();
  }


getAllDep(){
  this.depService.getAllDep()
  .subscribe(
    res=>{
      this.departmentData=res
    }
  )
}

saveDep(){
  this.department.name=this.formValue.value.name;
  this.depService.saveDep(this.department)
  .subscribe(res=>{
    this.formValue.reset();
    this.getAllDep();
  },
  err=>{
    alert("Data Not Save")
  }
    
  )
}
}
