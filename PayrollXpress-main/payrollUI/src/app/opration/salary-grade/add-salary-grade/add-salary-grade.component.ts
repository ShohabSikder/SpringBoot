import { Component } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { SalaryGrade } from 'src/app/model/salary-grade.model';
import { SalaryGradeService } from 'src/app/services/salary-grade.service';

@Component({
  selector: 'app-add-salary-grade',
  templateUrl: './add-salary-grade.component.html',
  styleUrls: ['./add-salary-grade.component.css']
})
export class AddSalaryGradeComponent {
  sg: SalaryGrade = new SalaryGrade();

//If salary grade exist already ids's (6) then this table will be update, not add new...
  s: number | undefined;
  ngOnInit(){
    this.s = this.route.snapshot.params['id'];
    if (this.s != 0){
      this.sg.id = 6;
    }

    console.log(this.s)
  }
  submitted=false;

  constructor(
    private salaryGradeService : SalaryGradeService,
    private router: Router,
    private route: ActivatedRoute
    ) { }

//If salary grade exist already ids's (6) then this table will be update, not add new...
  salaryGradeAdd(){
    this.submitted = true;
    this.salaryGradeService.addSalaryGrade(this.sg).subscribe(
      data => alert('Salary Grade added successfull!!'),
       error => alert('Something is wrong, please try again!!')
    );
    this.router.navigate(['/allsalarygrade']);

  }
}
