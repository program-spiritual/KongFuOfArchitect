package encryptionAndSecurity.digest;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Demo {

  //    SHA-1也是一种哈希算法，它的输出是160 bits，即20字节。
  //   SHA-1是由美国国家安全局开发的，
  //  SHA算法实际上是一个系列，包括SHA-0（已废弃）、SHA-1、SHA-256、SHA-512等。
  public static void main(String[] args) {
    // 创建一个MessageDigest实例:
    MessageDigest md = null;
    try {
      //            类似的，计算SHA-256，我们需要传入名称"SHA-256"，
      //           计算SHA-512，我们需要传入名称"SHA-512"。
      //          Java标准库支持的所有哈希算法可以在这里查到。
      md = MessageDigest.getInstance("SHA-1");
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
    byte[] result = md.digest(); // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
    System.out.println(new BigInteger(1, result).toString(16));
  }
}
