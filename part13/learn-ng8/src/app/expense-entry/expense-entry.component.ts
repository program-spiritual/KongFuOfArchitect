import {Component, OnInit} from '@angular/core';
import {ExpenseEntry} from '../expense-entry';

@Component({
  selector: 'app-expense-entry',
  templateUrl: './expense-entry.component.html',
  styleUrls: ['./expense-entry.component.scss']
})
export class ExpenseEntryComponent implements OnInit {
  title: string;
  expenseEntry: ExpenseEntry;

  constructor() {
  }

  ngOnInit() {
    this.title = 'EXPENSE ENTRY';
    this.expenseEntry = {
      id: 1,
      item: 'Pizza',
      amount: 21,
      category: 'Food',
      location: 'Zomato',
      spendOn: new Date(2020, 6, 1, 10, 10, 10), createdOn: new Date(2020, 6, 1, 10, 10, 10),
    };
  }

}
