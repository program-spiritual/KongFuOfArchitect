public class UseAnnotationDemo1 {

  public static void main(String[] args) {}
}

//注释会被编译器直接忽略，注解则可以被编译器打包进入class文件，因此，注解是一种用作标注的“元数据”。
// this is a component:
@interface Check {
  int min() default 0;

  int max() default 100;

  int value() default 0;
}

class UseAnnotationDemo1Hello {

  @Check(min = 0, max = 100, value = 55)
  public int n;

  @Check(value = 99)
  public int p;

  @Check(99) // @Check(value=99)
  public int x;

  @Check
  public int y;
}
//@Check就是一个注解。第一个@Check(min=0, max=100, value=55)明确定义了三个参数，第二个@Check(value=99)只定义了一个value参数，它实际上和@Check(99)是完全一样的。最后一个@Check表示所有参数都使用默认值。
/**
 * 注解（Annotation）是Java语言用于工具处理的标注：
 *
 * 注解可以配置参数，没有指定配置的参数使用默认值；
 *
 * 如果参数名称是value，且只有一个参数，那么可以省略参数名称。
 * */
