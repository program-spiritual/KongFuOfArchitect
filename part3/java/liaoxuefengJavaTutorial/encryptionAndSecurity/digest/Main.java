package encryptionAndSecurity.digest;
/*****************************************************************************************************
 * 哈希算法最重要的特点就是：
 *
 * 相同的输入一定得到相同的输出；
 * 不同的输入大概率得到不同的输出。
 * 哈希算法的目的就是为了验证原始数据是否被篡改。
 *
 * Java字符串的hashCode()就是一个哈希算法，它的输入是任意字符串，输出是固定的4字节int整数：
 *
 *
 * ****************************************************************************************************/
public class Main {
    public static void main(String[] args) {
        "hello".hashCode(); // 0x5e918d2
        "hello, java".hashCode(); // 0x7a9d88e8
        "hello, bob".hashCode(); // 0xa0dbae2f
/**
 *
 * 两个相同的字符串永远会计算出相同的hashCode，否则基于hashCode定位的HashMap就无法正常工作。
 * 这也是为什么当我们自定义一个class时，覆写equals()方法时我们必须正确覆写hashCode()方法。
 *
 * */

    }
}
