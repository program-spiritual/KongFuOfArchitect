import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class JavaExceptionDemo3 {

  //    如果是测试代码，上面的写法就略显麻烦。如果不想写任何try代码，可以直接把main()方法定义为throws Except
  public static void main(String[] args) throws Exception {
    byte[] bs = toGBK("中文");
    System.out.println(Arrays.toString(bs));
  }

  static byte[] toGBK(String s) {
    //        如果我们不捕获UnsupportedEncodingException，会出现编译失败的问题：
    try {
      // 用指定编码转换String为byte[]:
      return s.getBytes("GBK");
    } catch (UnsupportedEncodingException e) {
      // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
      System.out.println(e); // 打印异常信息
      return s.getBytes(); // 尝试使用用默认编码
    }
  }
  //    编译器会报错，错误信息类似：unreported exception UnsupportedEncodingException; must be caught or declared to be thrown，并且准确地指出需要捕获的语句是return s.getBytes("GBK");。意思是说，像UnsupportedEncodingException这样的Checked Exception，必须被捕获。
  //
  //这是因为String.getBytes(String)方法定义是：
  //
  //public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
  //    ...
  //}
  //    方法定义的时候，使用throws Xxx表示该方法可能抛出的异常类型。调用方在调用的时候，必须强制捕获这些异常，否则编译器会报错。
  //
  //在toGBK()方法中，因为调用了String.getBytes(String)方法，就必须捕获UnsupportedEncodingException。
  //我们也可以不捕获它，而是在方法定义处用throws表示toGBK()方法可能会抛出UnsupportedEncodingException，
  //就可以让toGBK()方法通过编译器检查：
  //    可见，只要是方法声明的Checked Exception，不在调用层捕获，也必须在更高的调用层捕获。
  //   所有未捕获的异常，最终也必须在main()方法中捕获，不会出现漏写try的情况。
  //  这是由编译器保证的。main()方法也是最后捕获Exception的机会。

  //    还有一些童鞋喜欢在toGBK()内部“消化”异常：
  //     try {
  //        return s.getBytes("GBK");
  //    } catch (UnsupportedEncodingException e) {
  //        // 什么也不干
  //    }

  //    这种捕获后不处理的方式是非常不好的，即使真的什么也做不了，也要先把异常记录下来：
  //
  //static byte[] toGBK(String s) {
  //    try {
  //        return s.getBytes("GBK");
  //    } catch (UnsupportedEncodingException e) {
  //        // 先记下来再说:
  //        e.printStackTrace();
  //    }
  //    return null;

  //    所有异常都可以调用printStackTrace()方法打印异常栈，这是一个简单有用的快速打印异常的方法。

}
