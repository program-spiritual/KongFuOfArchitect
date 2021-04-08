package packageDemo;

import java.io.*;

public class EmployeeTest {

  public static void main(String args[]) {
    /* Create two objects using constructor */
    Employee2 empOne = new Employee2("James Smith");
    Employee2 empTwo = new Employee2("Mary Anne");

    // Invoking methods for each object created
    empOne.empAge(26);
    empOne.empDesignation("Senior Software Engineer");
    empOne.empSalary(1000);
    empOne.printEmployee();

    empTwo.empAge(21);
    empTwo.empDesignation("Software Engineer");
    empTwo.empSalary(500);
    empTwo.printEmployee();
  }
}
