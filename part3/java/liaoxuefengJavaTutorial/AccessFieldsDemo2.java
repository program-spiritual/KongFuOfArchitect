import java.lang.reflect.Field;

public class AccessFieldsDemo2 {

  public static void main(String[] args)
    throws NoSuchFieldException, IllegalAccessException {
    //        利用反射拿到字段的一个Field实例只是第一步，我们还可以拿到一个实例对应的该字段的值。
    //
    //        例如，对于一个Person实例，我们可以先拿到name字段对应的Field，再获取这个实例的name字段的值：
    Object p = new Person("Xiao Ming");
    Class c = p.getClass();
    Field f = c.getDeclaredField("name");
    Object value = f.get(p);
    System.out.println(value); // "Xiao Ming"
    //        运行代码，如果不出意外，会得到一个IllegalAccessException，
    //       这是因为name被定义为一个private字段，正常情况下，Main类无法访问Person类的private字段。要修复错误
    //      ，可以将private改为public，或者，在调用Object value = f.get(p);前，先写一句f.setAccessible(true);
    //     ：
    //        有童鞋会问：如果使用反射可以获取private字段的值，那么类的封装还有什么意义？
    //
    //答案是正常情况下，我们总是通过p.name来访问Person的name字段，编译器会根据public、protected和private决定是否允许访问字段，这样就达到了数据封装的目的。
    //
    //而反射是一种非常规的用法，使用反射，首先代码非常繁琐，其次，它更多地是给工具或者底层框架来使用，目的是在不知道目标实例任何信息的情况下，获取特定字段的值。
    //
    //此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)。例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全。
  }
}
