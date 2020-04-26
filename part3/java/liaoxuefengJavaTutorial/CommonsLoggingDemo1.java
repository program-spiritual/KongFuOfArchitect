
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//因为Commons Logging是一个第三方提供的库，所以，必须先把它下载下来。下
//载后，解压，找到commons-logging-1.2.jar这个文件，
//再把Java源码Main.java放到一个目录下，例如work目录：

/**
 * 和Java标准库提供的日志不同，Commons Logging是一个第三方日志库，它是由Apache创建的日志模块。
 *
 * Commons Logging的特色是，它可以挂接不同的日志系统，并通过配置文件指定挂接的日志系统。默认情况下，Commons Loggin自动搜索并使用Log4j（Log4j是另一个流行的日志系统），如果没有找到Log4j，再使用JDK Logging。
 *
 * 使用Commons Logging只需要和两个类打交道，并且只有两步：
 *
 * 第一步，通过LogFactory获取Log类的实例； 第二步，使用Log实例的方法打日志。
 * 然后用javac编译Main.java，编译的时候要指定classpath，不然编译器找不到我们引用的org.apache.commons.logging包。编译命令如下：
 *
 * javac -cp commons-logging-1.2.jar Main.java
 *
 * 现在可以执行这个Main.class，使用java命令，也必须指定classpath，命令如下：
 *
 * java -cp .;commons-logging-1.2.jar Main
 * 注意到传入的classpath有两部分：
 * 一个是.，一个是commons-logging-1.2.jar，用;分割。
 * .表示当前目录，如果没有这个.，
 * JVM不会在当前目录搜索Main.class，就会报错。
 * 如果在Linux或macOS下运行，注意classpath的分隔符不是;，而是:：
 *
 * java -cp .:commons-logging-1.2.jar Main
 *
 * Commons Logging定义了6个日志级别：
 *
 * FATAL
 * ERROR
 * WARNING
 * INFO
 * DEBUG
 * TRACE
 * 默认级别是INFO。
 *
 * 使用Commons Logging时，如果在静态方法中引用Log，通常直接定义一个静态类型变量：
 * */
public class CommonsLoggingDemo1 {
    static final Log log = LogFactory.getLog(CommonsLoggingDemo1.class);

    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLoggingDemo1.class);
        log.info("start...");
        log.warn("end.");
    }


    static void foo() {
        log.info("foo");
    }
}
