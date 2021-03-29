import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseEntryListComponent } from './expense-entry-list.component';

describe('ExpenseEntryListComponent', () => {
  let component: ExpenseEntryListComponent;
  let fixture: ComponentFixture<ExpenseEntryListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpenseEntryListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpenseEntryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
