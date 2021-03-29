import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { ExpenseEntryComponent } from './expense-entry/expense-entry.component';
import { TestComponent } from './test/test.component';
import { CustomstyleDirective } from './customstyle.directive';
import { ChildComponent } from './child/child.component';
import { ExpenseEntryListComponent } from './expense-entry-list/expense-entry-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ExpenseEntryComponent,
    TestComponent,
    CustomstyleDirective,
    ChildComponent,
    ExpenseEntryListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
