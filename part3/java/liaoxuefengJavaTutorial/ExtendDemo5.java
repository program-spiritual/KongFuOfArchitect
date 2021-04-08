public class ExtendDemo5 {

  public static void main(String[] args) {
    //        为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型：
    Person10 p = new Person10();
    System.out.println(p instanceof Person10); // true
    System.out.println(p instanceof Student); // false

    Student s = new Student();
    System.out.println(s instanceof Person10); // true
    System.out.println(s instanceof Student); // true

    Student n = null;
    System.out.println(n instanceof Student); // false
  }
}
