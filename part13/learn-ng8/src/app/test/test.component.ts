import {Component, OnInit} from '@angular/core';
import {User} from '../user';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {
  appName = 'My first app in angular8';
  userName = 'petter';
  myCSSClass = 'red';
  applyCSSClass = false;
  myStyle = 'brown';
  isLogIn = false;
  isLogOut = true;
  list = [1, 2, 3, 4, 5];
  students = [
    {
      id: 1,
      name: 'student1'
    },
    {
      id: 2,
      name: 'student2'
    },
    {
      id: 3, name: 'student3'
    },
    {
      id: 4,
      name: 'student4'
    }
  ];
  logInName = 'admin';
  users: User[] = [
    {
      userId: 1,
      userName: 'User1'
    },
    {
      userId: 2,
      userName: 'User2'
    }
  ];
  Fruits = ['mango', 'apple', 'orange', 'grapes'];
  name = 'Peter';

  constructor() {
  }

  ngOnInit() {
  }

  trackByData(index: number, student: any): number {
    console.log('student:', student);
    return student.id;
  }

  showData($event: any) {
    console.log('button is clicked');
    if ($event) {
      console.log($event.target);
      console.log($event.target.value);
    }
  }

}
