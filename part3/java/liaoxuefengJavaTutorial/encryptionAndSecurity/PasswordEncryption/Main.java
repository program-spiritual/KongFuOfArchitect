package encryptionAndSecurity.PasswordEncryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * PBE的作用就是把用户输入的口令和一个安全随机的口令采用杂凑后计算出真正的密钥。
 * 以AES密钥为例，我们让用户输入一个口令，然后生成一个随机数，
 * 通过PBE算法计算出真正的AES口令，再进行加密，代码如下：
 * key = generate(userPassword, secureRandomPassword);
 * */
public class Main {
    public static void main(String[] args) {
//PBE的作用就是把用户输入的口令和一个安全随机的口令采用杂凑后计算出真正的密钥。
//以AES密钥为例，我们让用户输入一个口令，然后生成一个随机数，通过PBE算法计算出真正的AES口令，再进行加密，代码如下：
        // 把BouncyCastle作为Provider添加到java.security:
        Security.addProvider(new BouncyCastleProvider());
        // 原文:
        String message = "Hello, world!";
        // 加密口令:
        String password = "hello12345";
        // 16 bytes随机Salt:
        byte[] salt = new byte[0];
        try {
            salt = SecureRandom.getInstanceStrong().generateSeed(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.printf("salt: %032x\n", new BigInteger(1, salt));
        // 加密:
        byte[] data = new byte[0];
        try {
            data = message.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] encrypted = new byte[0];
        try {
            encrypted = encrypt(password, salt, data);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        System.out.println("encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = new byte[0];
        try {
            decrypted = decrypt(password, salt, encrypted);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("decrypted: " + new String(decrypted, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // 加密:
    public static byte[] encrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = null;
        try {
            skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey skey = null;
        try {
            skey = skeyFactory.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        try {
            cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
//        使用PBE时，我们还需要引入BouncyCastle，并指定算法是PBEwithSHA1and128bitAES-CBC-BC。
//       观察代码，实际上真正的AES密钥是调用Cipher的init()方法时同时传入SecretKey和PBEParameterSpec实现的。
//      在创建PBEParameterSpec的时候，我们还指定了循环次数1000，循环次数越多，暴力破解需要的计算量就越大。
        cipher.init(Cipher.DECRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }
}
