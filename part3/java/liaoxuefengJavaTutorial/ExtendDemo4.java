public class ExtendDemo4 {

  public static void main(String[] args) {
    //        和向上转型相反，如果把一个父类类型强制转型为子类类型，就是向下转型（downcasting）。例如：
    Person10 p1 = new Student(); // upcasting, ok
    Person10 p2 = new Person10();
    Student s1 = (Student) p1; // ok
    Student s2 = (Student) p2; // runtime error! ClassCastException! Exception in thread "main" java.lang.ClassCastException: class Person10 cannot be cast to class Student (Person10 and Student are in unnamed module of loader 'app')
    //        Person类型p1实际指向Student实例，Person类型变量p2实际指向Person实例。
    //       在向下转型的时候，把p1转型为Student会成功，因为p1确实指向Student实例，把p2转型为Student会失败，
    //      因为p2的实际类型是Person，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。
    //
    //因此，向下转型很可能会失败。失败的时候，Java虚拟机会报ClassCastException。
  }
}
