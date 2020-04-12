public class IfJudgmentDemo5 {
    public static void main(String[] args) {
//        在Java中，判断值类型的变量是否相等，可以使用==运算符。
//       但是，判断引用类型的变量是否相等，==表示“引用是否相等”，
//       或者说，是否指向同一个对象。例如，下面的两个String类型，
//      它们的内容是相同的，但是，分别指向不同的对象，用==判断，结果为false：
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
//        要判断引用类型的变量内容是否相等，必须使用equals()方法：
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }

//        执行语句s1.equals(s2)时，如果变量s1为null，会报NullPointerException
        String s3 = null;
        if (s3.equals("hello")) {
            System.out.println("hello"); // Exception in thread "main" java.lang.NullPointerException
        }

//        要避免NullPointerException错误，可以利用短路运算符&&：
        String s4 = null;
        if (s4 != null && s4.equals("hello")) {
            System.out.println("hello");
        }

//        还可以把一定不是null的对象"hello"放到前面：例如：if ("hello".equals(s)) { ... }。
    }
}
