import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JAndLogbackDemo1 {

  //    我们先来看看SLF4J对Commons Logging的接口有何改进。在Commons Logging中，我们要打印日志，有时候得这么写：
  public static void main(String[] args) {
    //    我们先来看看SLF4J对Commons Logging的接口有何改进。在Commons Logging中，我们要打印日志，有时候得这么写：
    //
    //    int score = 99;
    //    p.setScore(score);
    //    log.info("Set score " + score + " for Person " + p.getName() + " ok.");
    //    拼字符串是一个非常麻烦的事情，所以SLF4J的日志接口改进成这样了：
    //
    //    int score = 99;
    //    p.setScore(score);
    //    logger.info("Set score {} for Person {} ok.", score, p.getName());
    //    如何使用SLF4J？它的接口实际上和Commons Logging几乎一模一样：

    //    然后使用SLF4J的Logger和LoggerFactory即可。和Log4j类似，我们仍然需要一个Logback的配置文件，把logback.xml放到classpath下，配置如下：

    var s = new Student12();
    s.testLogError();
  }
}

class Student12 {

  final Logger logger = LoggerFactory.getLogger(getClass());

  void bar() {
    logger.info("bar");
  }

  void testLogError() {
    try {
      throw new UnsupportedOperationException();
    } catch (Exception e) {
      logger.error("got exception!", e);
    }
  }
}
