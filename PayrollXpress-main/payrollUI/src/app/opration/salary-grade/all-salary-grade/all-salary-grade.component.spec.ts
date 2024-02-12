import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllSalaryGradeComponent } from './all-salary-grade.component';

describe('AllSalaryGradeComponent', () => {
  let component: AllSalaryGradeComponent;
  let fixture: ComponentFixture<AllSalaryGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllSalaryGradeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllSalaryGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
