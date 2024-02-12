import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllBankAccountComponent } from './all-bank-account.component';

describe('AllBankAccountComponent', () => {
  let component: AllBankAccountComponent;
  let fixture: ComponentFixture<AllBankAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllBankAccountComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllBankAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
