package encryptionAndSecurity.bouncyCastle;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * BouncyCastle就是一个提供了很多哈希算法和加密算法的第三方库。
 * 它提供了Java标准库没有的一些算法，例如，RipeMD160哈希算法。
 *
 * 我们来看一下如何使用BouncyCastle这个第三方提供的算法。
 *Java标准库的java.security包提供了一种标准机制，允许第三方提供商无缝接入。
 * 我们要使用BouncyCastle提供的RipeMD160算法，需要先把BouncyCastle注册一下：
 * 注册只需要在启动时进行一次，后续就可以使用BouncyCastle提供的所有哈希算法和加密算法
 * */
public class Main {

  public static void main(String[] args) {
    // 注册BouncyCastle:
    Security.addProvider(new BouncyCastleProvider());
    // 按名称正常调用:
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("RipeMD160");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    try {
      md.update("HelloWorld".getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    byte[] result = md.digest();
    System.out.println(new BigInteger(1, result).toString(16));
  }
}
