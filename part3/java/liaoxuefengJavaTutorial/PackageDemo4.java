import java.text.Format;
import java.text.MessageFormat;

public class PackageDemo4 {

  /**
   * Java编译器最终编译出的.class文件只使用完整类名，因此，在代码中，当编译器遇到一个class名称时：
   *
   * 如果是完整类名，就直接根据完整类名查找这个class；
   *
   * 如果是简单类名，按下面的顺序依次查找：
   *
   * 查找当前package是否存在这个class；
   *
   * 查找import的包是否包含这个class；
   *
   * 查找java.lang包是否包含这个class。
   *
   * 如果按照上面的规则还无法确定类名，则编译报错。
   * */
  public static void main(String[] args) {
    java.util.List list; // ok，使用完整类名 -> java.util.List
    Format format = null; // ok，使用import的类 -> java.text.Format
    String s = "hi"; // ok，使用java.lang包的String -> java.lang.String
    System.out.println(s); // ok，使用java.lang包的System -> java.lang.System
    MessageFormat mf = null; // 编译错误：无法找到MessageFormat: MessageFormat cannot be resolved to a type Error:(24, 9) java: 找不到符号
    //        因此，编写class的时候，编译器会自动帮我们做两个import动作：
    //
    //默认自动import当前package的其他class；
    //
    //默认自动import java.lang.*。注意：自动导入的是java.lang包，但类似java.lang.reflect这些包仍需要手动导入
    //        如果有两个class名称相同，例如，mr.jun.Arrays和java.util.Arrays，那么只能import其中一个，另一个必须写完整类名。
  }
}
