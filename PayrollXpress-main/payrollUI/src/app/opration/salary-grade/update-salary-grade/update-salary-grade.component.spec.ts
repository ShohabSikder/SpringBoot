import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSalaryGradeComponent } from './update-salary-grade.component';

describe('UpdateSalaryGradeComponent', () => {
  let component: UpdateSalaryGradeComponent;
  let fixture: ComponentFixture<UpdateSalaryGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateSalaryGradeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateSalaryGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
