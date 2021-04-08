public class CallMethodDemo1 {

  public static void main(String[] args) throws NoSuchMethodException {
    //        我们已经能通过Class实例获取所有Field对象，同样的，可以通过Class实例获取所有Method信息。Class类提供了以下几个方法来获取Method：
    //
    //Method getMethod(name, Class...)：获取某个public的Method（包括父类）
    //Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
    //Method[] getMethods()：获取所有public的Method（包括父类）
    //Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）

    // 获取private方法getGrade，参数为int: Class stdClass = Student.class;
    // 获取public方法getScore，参数为String:
    Class stdClass = Student24.class;
    System.out.println(stdClass.getMethod("getScore", String.class));
    // 获取继承的public方法getName，无参数:
    System.out.println(stdClass.getMethod("getName"));
    System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
  }
}

class Student24 extends Person27 {

  public int getScore(String type) {
    return 99;
  }

  private int getGrade(int year) {
    return 1;
  }
}

class Person27 {

  public String getName() {
    return "Person";
  }
}
