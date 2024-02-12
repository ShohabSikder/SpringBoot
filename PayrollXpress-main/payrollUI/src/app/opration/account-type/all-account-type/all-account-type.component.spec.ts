import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllAccountTypeComponent } from './all-account-type.component';

describe('AllAccountTypeComponent', () => {
  let component: AllAccountTypeComponent;
  let fixture: ComponentFixture<AllAccountTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllAccountTypeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllAccountTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
