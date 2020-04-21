public class PackagingTypeDemo3 {
    public static void main(String[] args) {
//        Integer类本身还提供了大量方法，例如，最常用的静态方法parseInt()可以把字符串解析成一个整数
        int x1 = Integer.parseInt("100"); // 100
        int x2 = Integer.parseInt("100", 16); // 256,因为按16进制解析

//        Integer还可以把整数格式化为指定进制的字符串：

        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toString(100, 3)); // "10201" 表示为3进制
        System.out.println(Integer.toString(100, 6)); //  "244" // 表示为 6 进制
        System.out.println(Integer.toString(100, 9)); //  "121"  // 表示为 9 进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制

//        上述方法的输出都是String，在计算机内存中，只用二进制表示，不存在十进制或十六进制的表示方法。int n = 100在内存中总是以4字节的二进制表示：
/**
 * ┌────────┬────────┬────────┬────────┐
 * │00000000│00000000│00000000│01100100│
 * └────────┴────────┴────────┴────────┘
 *我们经常使用的System.out.println(n);是依靠核心库自动把整数格式化为10进制输出并显示在屏幕上，
 * 使用Integer.toHexString(n)则通过核心库自动把整数格式化为16进制。
 * 这里我们注意到程序设计的一个重要原则：数据的存储和显示要分离。
 * */


//        Java的包装类型还定义了一些有用的静态变量

        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
// int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
// long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)

//        最后，所有的整数和浮点数的包装类型都继承自Number，因此，可以非常方便地直接通过包装类型获取各种基本类型：
        // 向上转型为Number:
        Number num = new Integer(999);
// 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n = num.intValue();
        long ln = num.longValue();
        float g = num.floatValue();
        double h = num.doubleValue();

//        在Java中，并没有无符号整型（Unsigned）的基本数据类型。
//       byte、short、int和long都是带符号整型，最高位是符号位。
//      而C语言则提供了CPU支持的全部数据类型，包括无符号整型。
//     无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成。

//        例如，byte是有符号整型，范围是-128~+127，但如果把byte看作无符号整型，它的范围就是0~255。
//       我们把一个负的byte按无符号整型转换为int：
        byte x = -1;
        byte y = 127;
        System.out.println(Byte.toUnsignedInt(x)); // 255
        System.out.println(Byte.toUnsignedInt(y)); // 127
    }

}
