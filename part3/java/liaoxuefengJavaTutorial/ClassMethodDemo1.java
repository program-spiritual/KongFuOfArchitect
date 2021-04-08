public class ClassMethodDemo1 {

  public static void main(String[] args) {
    //        但是，直接把field用public暴露给外部可能会破坏封装性。比如，代码可以这样写：

    Person2 ming = new Person2();
    ming.name = "Xiao Ming";
    ming.age = -99; // age设置为负数

    Person3 ming3 = new Person3();
    //        ming3.name = "Xiao Ming"; // Error:(10, 14) java: name 在 Person3 中是 private 访问控制
    //        ming3.age = -99; // age设置为负数  // Error:(11, 14) java: age 在 Person3 中是 private 访问控制
  }
}

class Person2 {

  public String name;
  public double age;
}

// 显然，直接操作field，容易造成逻辑混乱。为了避免外部代码直接去访问field，我们可以用private修饰field，拒绝外部访问：

/**
 * 定义方法的语法是：
 * <p>
 * 修饰符 方法返回类型 方法名(方法参数列表) {
 * 若干方法语句;
 * return 方法返回值;
 * }
 */
class Person3 {

  private String name;
  private double age;
  private int birth;

  public int getBirth() {
    return birth;
  }

  public void setBirth(int birth) {
    this.birth = birth;
  }

  public String getName() {
    return name;
  }

  //对setName()方法同样可以做检查，例如，不允许传入null和空字符串：
  public void setName(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("invalid name");
    }
    this.name = name;
  }

  //同样，外部代码不能直接读取private字段，但可以通过getName()和getAge()间接获取private字段的值。
  //
  //所以，一个类通过定义方法，就可以给外部代码暴露一些操作的接口，同时，内部自己保证逻辑一致性。
  //
  //调用方法的语法是实例变量.方法名(参数);。一个方法调用就是一个语句，所以不要忘了在末尾加;。例如：ming.setName("Xiao Ming");。
  //    方法返回值通过return语句实现，如果没有返回值，返回类型设置为void，可以省略return。
  // 把field从public改成private，外部代码不能访问这些field，那我们定义这些field有什么用？怎么才能给它赋值？怎么才能读取它的值？
  // 虽然外部代码不能直接修改private字段，
  //但是，外部代码可以调用方法setName()和setAge()来间接修改private字段。
  //在方法内部，我们就有机会检查参数对不对。
  //定义private方法的理由是内部方法是可以调用private方法的。例如：
  //此外，我们还注意到，这个Person类只定义了birth字段，没有定义age字段，获取age时，通过方法getAge()返回的是一个实时计算的值，并非存储在某个字段的值。这说明方法可以封装一个类的对外接口，调用方不需要知道也不关心Person实例在内部到底有没有age字段。
  //    有public方法，自然就有private方法。和private字段一样，private方法不允许外部调用，那我们定义private方法有什么用？
  public int getAge() {
    return calcAge(2019); // 调用private方法
  }

  //比如，setAge()就会检查传入的参数，参数超出了范围，直接报错。这样，外部代码就没有任何机会把age设置成不合理的值。
  public void setAge(double age) {
    if (age < 0 || age > 100) {
      throw new IllegalArgumentException("invalid age value");
    }
    this.age = age;
  }

  // private方法:
  private int calcAge(int currentYear) {
    return currentYear - this.birth;
  }
  //    观察上述代码，calcAge()是一个private方法，外部代码无法调用，但是，内部方法getAge()可以调用它。
  //

  //
}
