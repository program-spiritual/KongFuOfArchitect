package encryptionAndSecurity.signature;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * 私钥加密得到的密文实际上就是数字签名，要验证这个签名是否正确，
 * 只能用私钥持有者的公钥进行解密验证。使用数字签名的目的是为了确认某个信息确实是由某个发送方发送的，
 * 任何人都不可能伪造消息，并且，发送方也不能抵赖。
 * <p>
 * 在实际应用的时候，签名实际上并不是针对原始消息，而是针对原始消息的哈希进行签名，即：
 * signature = encrypt(privateKey, sha256(message))
 * <p>
 * 常用数字签名算法有：
 * <p>
 * MD5withRSA
 * SHA1withRSA
 * SHA256withRSA
 * 它们实际上就是指定某种哈希算法进行RSA签名的方式。
 */
public class Main {
    public static void main(String[] args) {
// 生成RSA公钥/私钥:
        KeyPairGenerator kpGen = null;
        try {
            kpGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        PrivateKey sk = kp.getPrivate();
        PublicKey pk = kp.getPublic();

        // 待签名的消息:
        byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);

        // 用私钥签名:
        Signature s = null;
        try {
            s = Signature.getInstance("SHA1withRSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            s.initSign(sk);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            s.update(message);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        byte[] signed = new byte[0];
        try {
            signed = s.sign();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("signature: %x", new BigInteger(1, signed)));

        // 用公钥验证:
        Signature v = null;
        try {
            v = Signature.getInstance("SHA1withRSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            v.initVerify(pk);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            v.update(message);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        boolean valid = false;
        try {
            valid = v.verify(signed);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        System.out.println("valid? " + valid);
    }
}
