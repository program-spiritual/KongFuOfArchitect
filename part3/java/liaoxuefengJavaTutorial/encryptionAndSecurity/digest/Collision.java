package encryptionAndSecurity.digest;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * 使用MessageDigest时，我们首先根据哈希算法获取一个MessageDigest实例，
 * 然后，反复调用update(byte[])输入数据。
 * 当输入结束后，调用digest()方法获得byte[]数组表示的摘要，
 * 最后，把它转换为十六进制的字符串。
 * */
public class Collision {

  public static void main(String[] args) {
    //        哈希碰撞是指，两个不同的输入得到了相同的输出：
    //        ，因为输出的字节长度是固定的，String的hashCode()输出是4字节整数，最多只有4294967296种输出，
    //       但输入的数据长度是不固定的，有无数种输入。
    //      所以，哈希算法是把一个无限的输入集合映射到一个有限的输出集合，必然会产生碰撞。
    "AaAaAa".hashCode(); // 0x7460e8c0
    "BBAaBB".hashCode(); // 0x7460e8c0
    // 创建一个MessageDigest实例:
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    // 反复调用update输入数据:
    try {
      md.update("Hello".getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    try {
      md.update("World".getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
    System.out.println(new BigInteger(1, result).toString(16));
  }
  /**
   * 常用的哈希算法有：
   *
   * 算法	输出长度（位）	输出长度（字节）
   * MD5	128 bits	     16 bytes
   * SHA-1	160 bits	 20 bytes
   * RipeMD-160	160 bits 	20 bytes
   * SHA-256	256 bits	32 bytes
   * SHA-512	512 bits	64 bytes
   *
   * */
}
