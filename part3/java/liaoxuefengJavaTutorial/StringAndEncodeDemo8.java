public class StringAndEncodeDemo8 {
    public static void main(String[] args) {
//        String和char[]类型可以互相转换，方法是：
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s = new String(cs); // char[] -> String
//        如果修改了char[] 数组 String 并不会改变
        System.out.println(s);
        cs[0] = 'X';
        System.out.println(s);
//这是因为通过new String(char[])创建新的String实例时，它并不会直接引用传入的char[]数组，
//而是会复制一份，所以，修改外部的char[]数组不会影响String实例内部的char[]数组，因为这是两个不同的数组。
//
//从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用。
    }
}
