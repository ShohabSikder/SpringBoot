import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAccountTypeComponent } from './update-account-type.component';

describe('UpdateAccountTypeComponent', () => {
  let component: UpdateAccountTypeComponent;
  let fixture: ComponentFixture<UpdateAccountTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateAccountTypeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateAccountTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
