package encryptionAndSecurity.symmetric;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;
/**
 * Java标准库提供的对称加密接口非常简单，使用时按以下步骤编写代码：
 *
 * 根据算法名称/工作模式/填充模式获取Cipher实例；
 * 根据算法名称初始化一个SecretKey实例，密钥必须是指定长度；
 * 使用SerectKey初始化Cipher实例，并设置加密或解密模式；
 * 传入明文或密文，获得密文或明文。
 *
 * */
public class AESDemo {
    public static void main(String[] args) {
        // 原文:
        String message = "Hello, world!";
        System.out.println("Message: " + message);
        // 128位密钥 = 16 bytes Key:
        byte[] key = new byte[0];
        try {
            key = "1234567890abcdef".getBytes("UTF-8");
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
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
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
    public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }
}
