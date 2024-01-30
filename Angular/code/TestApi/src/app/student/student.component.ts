import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student.model';
import { Department } from '../model/department.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../service/student.service';
import { DepartmentService } from '../service/department.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent implements OnInit {
  students: Student[] = [];
  departments: Department[] = [];
  studentForm!: FormGroup;

 constructor(
  private studentService:StudentService,
  private formBuilder:FormBuilder,
  private departmentService: DepartmentService
  
 
 ){}

 ngOnInit(): void {
  this.loadStudents();
  this.initStudentForm();
  this.loadDepartments();
}

 private loadStudents(){
  this.studentService.getAllStudent().subscribe(
    data=> this.students=data,
    error=> console.error("Error fecthing student",error)
  )
 }
 private loadDepartments(){
  this.departmentService.getAllDep().subscribe(
    data=> this.departments=data,
    error=> console.error("Error fecthing student",error)
  )
 }

 private initStudentForm() {
  this.studentForm = this.formBuilder.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    department: [null, Validators.required] // Assuming you have a department dropdown
  });
}

onSubmit() {
  if (this.studentForm.valid) {
    const studentData: Student = this.studentForm.value;
    this.studentService.createStudent(studentData).subscribe(
      response => {
        console.log('Employee created successfully', response);
        this.loadStudents(); // Refresh the list of employees after creation
        this.studentForm.reset(); // Reset the form
      },
      error => alert('Error creating student')
    );
  }
}

}
