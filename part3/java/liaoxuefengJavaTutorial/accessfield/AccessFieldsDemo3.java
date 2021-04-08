package accessfield;

import java.lang.reflect.Field;

public class AccessFieldsDemo3 {

  public static void main(String[] args)
    throws NoSuchFieldException, IllegalAccessException {
    //通过Field实例既然可以获取到指定实例的字段值，自然也可以设置字段的值。
    //
    //设置字段值是通过Field.set(Object, Object)实现的，其中第一个Object参数是指定的实例，第二个Object参数是待修改的值。示例代码如下：
    Person p = new Person("Xiao Ming");
    System.out.println(p.getName()); // "Xiao Ming"
    Class c = p.getClass();
    Field f = c.getDeclaredField("name");
    f.setAccessible(true);
    f.set(p, "Xiao Hong");
    System.out.println(p.getName()); // "Xiao Hong"
    //        运行上述代码，打印的name字段从Xiao Ming变成了Xiao Hong，说明通过反射可以直接修改字段的值。
    //
    //同样的，修改非public字段，需要首先调用setAccessible(true)。
  }
}
