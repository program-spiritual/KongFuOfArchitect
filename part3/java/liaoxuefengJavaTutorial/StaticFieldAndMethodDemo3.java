public class StaticFieldAndMethodDemo3 {

  public static void main(String[] args) {}
}

//因为interface是一个纯抽象类，所以它不能定义实例字段。但是，interface是可以有静态字段的，并且静态字段必须为final类型：

interface Person23 {
  public static final int MALE = 1;
  public static final int FEMALE = 2;
}

//实际上，因为interface的字段只能是public static final类型，所以我们可以把这些修饰符都去掉，上述代码可以简写为：

interface Person24 {
  // 编译器会自动加上public statc final:
  int MALE = 1;
  int FEMALE = 2;
}
//编译器会自动把该字段变为public static final类型。
