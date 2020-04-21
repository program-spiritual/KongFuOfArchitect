public class StringAndEncodeDemo7 {
    public static void main(String[] args) {
//        要把任意基本类型或引用类型转换为字符串，
//       可以使用静态方法valueOf()。
//      这是一个重载方法，编译器会根据参数自动选择合适的方法
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c
//        要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为int类型：
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
//        把字符串转换为boolean类型：
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false
//        要特别注意，Integer有个getInteger(String)方法，
//       它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
        Integer javaVersion =  Integer.getInteger("java.version"); // 版本号，11
        System.out.println(javaVersion);
        System.out.println(javaVersion instanceof Integer);
    }
}
