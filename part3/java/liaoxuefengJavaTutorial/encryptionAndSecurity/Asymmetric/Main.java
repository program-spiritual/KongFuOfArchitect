package encryptionAndSecurity.Asymmetric;

/***
 * 实际应用的时候，非对称加密总是和对称加密一起使用。假设小明需要给小红需要传输加密文件，他俩首先交换了各自的公钥，然后：
 *
 * 小明生成一个随机的AES口令，然后用小红的公钥通过RSA加密这个口令，并发给小红；
 * 小红用自己的RSA私钥解密得到AES口令；
 * 双方使用这个共享的AES口令用AES加密通信。
 *
 *
 *
 * 如果修改待加密的byte[]数据的大小，可以发现，使用512bit的RSA加密时，
 * 明文长度不能超过53字节，使用1024bit的RSA加密时，明文长度不能超过117字节，
 * 这也是为什么使用RSA的时候，总是配合AES一起使用，
 * 即用AES加密任意长度的明文，用RSA加密AES口令。
 * */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import javax.crypto.Cipher;

public class Main {

  public static void main(String[] args) {
    // 明文:
    byte[] plain = new byte[0];
    try {
      plain = "Hello, encrypt use RSA".getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    // 创建公钥／私钥对:
    Person alice = null;
    try {
      alice = new Person("Alice");
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    }
    // 用Alice的公钥加密:
    byte[] pk = alice.getPublicKey();
    System.out.println(String.format("public key: %x", new BigInteger(1, pk)));
    byte[] encrypted = new byte[0];
    try {
      encrypted = alice.encrypt(plain);
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    }
    System.out.println(
      String.format("encrypted: %x", new BigInteger(1, encrypted))
    );
    // 用Alice的私钥解密:
    byte[] sk = alice.getPrivateKey();
    System.out.println(String.format("private key: %x", new BigInteger(1, sk)));
    byte[] decrypted = new byte[0];
    try {
      decrypted = alice.decrypt(encrypted);
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    }
    try {
      System.out.println(new String(decrypted, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  static class Person {

    String name;
    // 私钥:
    PrivateKey sk;
    // 公钥:
    PublicKey pk;

    public Person(String name) throws GeneralSecurityException {
      this.name = name;
      // 生成公钥／私钥对:
      KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
      kpGen.initialize(1024);
      KeyPair kp = kpGen.generateKeyPair();
      this.sk = kp.getPrivate();
      this.pk = kp.getPublic();
    }

    // 把私钥导出为字节
    public byte[] getPrivateKey() {
      return this.sk.getEncoded();
    }

    // 把公钥导出为字节
    public byte[] getPublicKey() {
      return this.pk.getEncoded();
    }

    // 用公钥加密:
    public byte[] encrypt(byte[] message) throws GeneralSecurityException {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.ENCRYPT_MODE, this.pk);
      return cipher.doFinal(message);
    }

    // 用私钥解密:
    public byte[] decrypt(byte[] input) throws GeneralSecurityException {
      Cipher cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.DECRYPT_MODE, this.sk);
      return cipher.doFinal(input);
    }
  }
}
