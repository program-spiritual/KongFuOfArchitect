/**
 * @author reverse
 * @link https://www.liaoxuefeng.com/wiki/1252599548343744/1255883729079552
 * 一个字节就是一个8位二进制数，即8个bit。它的二进制表示范围从00000000~11111111，换算成十进制是0~255，换算成十六进制是00~ff。
 * 内存单元从0开始编号，称为内存地址。每个内存单元可以看作一间房间，内存地址就是门牌号。
 *一个字节是1byte，1024字节是1K，1024K是1M，1024M是1G，1024G是1T。一个拥有4T内存的计算机的字节数量就是：
 *
 * 4T = 4 x 1024G
 *    = 4 x 1024 x 1024M
 *    = 4 x 1024 x 1024 x 1024K
 *    = 4 x 1024 x 1024 x 1024 x 1024
 *    = 4398046511104
 *
 *    byte 1字节
 *    short 2字节
 *    int 4字节
 *    long 8字节
 *    float 4字节
 *    double 8字节
 *    char 2字节
 *    各种整型能表示的最大范围如下：
 *
 * byte：-128 ~ 127
 * short: -32768 ~ 32767
 * int: -2147483648 ~ 2147483647
 * long: -9223372036854775808 ~ 9223372036854775807
 * */
public class VariableAndDataType {

  public static void main(String[] args) {
    int n = 100; // 定义变量n，同时赋值为100
    System.out.println("n = " + n); // 打印n的值

    n = 200; // 变量n赋值为200
    System.out.println("n = " + n); // 打印n的值

    int x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
    System.out.println("x = " + x); // 打印x的值

    x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
    System.out.println("x = " + x); // 打印x的值
    System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？
  }
}
