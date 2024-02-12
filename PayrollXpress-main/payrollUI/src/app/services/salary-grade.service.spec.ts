import { TestBed } from '@angular/core/testing';

import { SalaryGradeService } from './salary-grade.service';

describe('SalaryGradeService', () => {
  let service: SalaryGradeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalaryGradeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
