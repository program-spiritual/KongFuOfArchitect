import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class JavaBeanDemo3 {

  public static void main(String[] args) throws IntrospectionException {
    BeanInfo info = Introspector.getBeanInfo(Person26.class);
    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
      System.out.println(pd.getName());
      System.out.println("  " + pd.getReadMethod());
      System.out.println("  " + pd.getWriteMethod());
    }
    //运行上述代码，可以列出所有的属性，以及对应的读写方法。注意class属性是从Object继承的getClass()方法带来的。
  }
}

class Person26 {

  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
