import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseEntryComponent } from './expense-entry.component';

describe('ExpenseEntryComponent', () => {
  let component: ExpenseEntryComponent;
  let fixture: ComponentFixture<ExpenseEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpenseEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpenseEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
