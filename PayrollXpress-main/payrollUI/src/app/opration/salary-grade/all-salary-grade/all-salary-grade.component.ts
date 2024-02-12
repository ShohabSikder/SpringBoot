import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SalaryGradeService } from 'src/app/services/salary-grade.service';

@Component({
  selector: 'app-all-salary-grade',
  templateUrl: './all-salary-grade.component.html',
  styleUrls: ['./all-salary-grade.component.css']
})
export class AllSalaryGradeComponent {
  constructor(
    private salaryGradeService : SalaryGradeService,
    private router:Router
    ){}

    salaryGradeList?: any;

    ngOnInit(){
    this.salaryGradeList = this.salaryGradeService.getAllSalaryGrade();


    }


    deleteSalaryGrade(id: number){
      this.salaryGradeService.deleteSalaryGradeById(id).subscribe(
        data=>{alert('Salary Grade successfully deleted!!');
          this.ngOnInit();
        },
        error=>alert('Somethig wrong, please try again!!')
        );
    }


    updateSalaryGrade(id: number){
      this.router.navigate(['updatesalarygrade/',id]);
    }

  saveOrUpdateSalary(){
      console.log(this.isSalaryGreateExit())
    this.router.navigate(['addsalarygrade/',this.isSalaryGreateExit()]);
  }

    isSalaryGreateExit():any{
      this.salaryGradeService.getSalaryLength().subscribe(
        data =>{
          this.router.navigate(['addsalarygrade/',data]);
          return data;
        }
      )
    }


}
