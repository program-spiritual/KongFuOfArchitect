package encryptionAndSecurity.symmetric;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * ECB模式是最简单的AES加密模式，它只需要一个固定长度的密钥，固定的明文会生成固定的密文，
 * 这种一对一的加密方式会导致安全性降低，更好的方式是通过CBC模式，
 * 它需要一个随机数作为IV参数，这样对于同一份明文，每次生成的密文都不同
 *在CBC模式下，需要一个随机生成的16字节IV参数，必须使用SecureRandom生成。
 * 因为多了一个IvParameterSpec实例，
 * 因此，初始化方法需要调用Cipher的一个重载方法并传入IvParameterSpec。
 * */
public class CBCMode {

  public static void main(String[] args) {
    // 原文:
    String message = "Hello, world!";
    System.out.println("Message: " + message);
    // 256位密钥 = 32 bytes Key:
    byte[] key = new byte[0];
    try {
      key = "1234567890abcdef1234567890abcdef".getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    // 加密:
    byte[] data = new byte[0];
    try {
      data = message.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    byte[] encrypted = new byte[0];
    try {
      encrypted = encrypt(key, data);
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    }
    System.out.println(
      "Encrypted: " + Base64.getEncoder().encodeToString(encrypted)
    );
    // 解密:
    byte[] decrypted = new byte[0];
    try {
      decrypted = decrypt(key, encrypted);
    } catch (GeneralSecurityException e) {
      e.printStackTrace();
    }
    try {
      System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  // 加密:
  public static byte[] encrypt(byte[] key, byte[] input)
    throws GeneralSecurityException {
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    // CBC模式需要生成一个16 bytes的initialization vector:
    SecureRandom sr = SecureRandom.getInstanceStrong();
    byte[] iv = sr.generateSeed(16);
    IvParameterSpec ivps = new IvParameterSpec(iv);
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
    byte[] data = cipher.doFinal(input);
    // IV不需要保密，把IV和密文一起返回:
    return join(iv, data);
  }

  // 解密:
  public static byte[] decrypt(byte[] key, byte[] input)
    throws GeneralSecurityException {
    // 把input分割成IV和密文:
    byte[] iv = new byte[16];
    byte[] data = new byte[input.length - 16];
    System.arraycopy(input, 0, iv, 0, 16);
    System.arraycopy(input, 16, data, 0, data.length);
    // 解密:
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    IvParameterSpec ivps = new IvParameterSpec(iv);
    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivps);
    return cipher.doFinal(data);
  }

  public static byte[] join(byte[] bs1, byte[] bs2) {
    byte[] r = new byte[bs1.length + bs2.length];
    System.arraycopy(bs1, 0, r, 0, bs1.length);
    System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
    return r;
  }
}
