public class ClassMethodDemo3 {

  public static void main(String[] args) {
    //        调用这个setNameAndAge()方法时，必须有两个参数，且第一个参数必须为String，第二个参数必须为int：

    Person4 ming = new Person4();
    //        ming.setNameAndAge("Xiao Ming"); // 编译错误：参数个数不对
    //        ming.setNameAndAge(12, "Xiao Ming"); // 编译错误：参数类型不对
  }
}

class Person4 {

  private String name;
  private double age;
  private int birth;

  //    方法可以包含0个或任意个参数。方法参数用于接收传递给方法的变量值。调用方法时，必须严格按照参数的定义一一传递。例如：
  public void setNameAndAge(String name, int age) {}
}
