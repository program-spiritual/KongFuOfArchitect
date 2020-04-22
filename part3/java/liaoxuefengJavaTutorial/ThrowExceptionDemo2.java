public class ThrowExceptionDemo2 {
    public static void main(String[] args) {
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        注意到Caused by: Xxx，说明捕获的IllegalArgumentException并不是造成问题的根源，根源在于NullPointerException，是在Main.process2()方法抛出的。
//
//在代码中获取原始异常可以使用Throwable.getCause()方法。如果返回null，说明已经是“根异常”了。
//
//有了完整的异常栈的信息，我们才能快速定位并修复代码的问题。

//        捕获到异常并再次抛出时，一定要留住原始异常，否则很难定位第一案发现场！
    }

    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void process2() {
        throw new NullPointerException();
    }
}
