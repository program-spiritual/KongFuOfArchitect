import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingDemo2 {

  protected final Log log = LogFactory.getLog(getClass());

  void foo() {
    log.info("foo");
  }

  public static void main(String[] args) {
    //此外，Commons Logging的日志方法，例如info()，除了标准的info(String)外，
    //还提供了一个非常有用的重载方法：info(String, Throwable)，这使得记录异常更加简单：
    var s = new Student11();
    s.testLogError();
  }
}

//注意到实例变量log的获取方式是LogFactory.getLog(getClass())，
//虽然也可以用LogFactory.getLog(Person.class)，
//但是前一种方式有个非常大的好处，就是子类可以直接使用该log实例。例如：

// 在子类中使用父类实例化的log:
class Student11 extends CommonsLoggingDemo2 {

  void bar() {
    log.info("bar");
  }

  void testLogError() {
    try {
      throw new UnsupportedOperationException();
    } catch (Exception e) {
      log.error("got exception!", e);
    }
  }
}
//由于Java类的动态特性，子类获取的log字段实际上相当于LogFactory.getLog(Student.class)，但却是从父类继承而来，并且无需改动代码。
//
