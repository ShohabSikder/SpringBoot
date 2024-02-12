import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SalaryGrade } from 'src/app/model/salary-grade.model';
import { SalaryGradeService } from 'src/app/services/salary-grade.service';

@Component({
  selector: 'app-update-salary-grade',
  templateUrl: './update-salary-grade.component.html',
  styleUrls: ['./update-salary-grade.component.css']
})
export class UpdateSalaryGradeComponent {
  id: number = 0;
  sg: SalaryGrade = new SalaryGrade();

  constructor(private salaryGradeService: SalaryGradeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.salaryGradeService.getSalaryGradeById(this.id).subscribe(
      data => {
        this.sg = data;
      }
    );
  }

  salaryGradeUpdate(){
    this.salaryGradeService.updateSalaryGrade(this.id, this.sg).subscribe(
      data => alert('Salary Grade updated successfull!!'),
       error => alert('Something is wrong, please try again!!'));   
       this.router.navigate(['/allsalarygrade']);
  }
}
