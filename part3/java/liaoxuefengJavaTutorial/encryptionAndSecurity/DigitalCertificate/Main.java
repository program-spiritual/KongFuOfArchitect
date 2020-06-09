package encryptionAndSecurity.DigitalCertificate;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import javax.crypto.Cipher;
/**
 * 在Java程序中，数字证书存储在一种Java专用的key store文件中，
 * JDK提供了一系列命令来创建和管理key store。
 * 我们用下面的命令创建一个key store，并设定口令123456：
 * keytool -storepass 123456 -genkeypair -keyalg RSA -keysize 1024 -sigalg SHA1withRSA -validity 3650 -alias mycert -keystore my.keystore -dname "CN=www.sample.com, OU=sample, O=sample, L=BJ, ST=BJ, C=CN"
 */

public class Main {
    public static void main(String[] args) {

        byte[] message = new byte[0];
        try {
            message = "Hello, use X.509 cert!".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 读取KeyStore:
        KeyStore ks = loadKeyStore("/my.keystore", "123456");
        // 读取私钥:
        PrivateKey privateKey = null;
        try {
            privateKey = (PrivateKey) ks.getKey("mycert", "123456".toCharArray());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
        // 读取证书:
        X509Certificate certificate = null;
        try {
            certificate = (X509Certificate) ks.getCertificate("mycert");
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        // 加密:
        byte[] encrypted = new byte[0];
        try {
            encrypted = encrypt(certificate, message);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("encrypted: %x", new BigInteger(1, encrypted)));
        // 解密:
        byte[] decrypted = new byte[0];
        try {
            decrypted = decrypt(privateKey, encrypted);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("decrypted: " + new String(decrypted, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 签名:
        byte[] sign = new byte[0];
        try {
            sign = sign(privateKey, certificate, message);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("signature: %x", new BigInteger(1, sign)));
        // 验证签名:
        boolean verified = false;
        try {
            verified = verify(certificate, message, sign);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        System.out.println("verify: " + verified);
    }

    static KeyStore loadKeyStore(String keyStoreFile, String password) {
        try (InputStream input = Main.class.getResourceAsStream(keyStoreFile)) {
            if (input == null) {
                throw new RuntimeException("file not found in classpath: " + keyStoreFile);
            }
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(input, password.toCharArray());
            return ks;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static byte[] encrypt(X509Certificate certificate, byte[] message) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(certificate.getPublicKey().getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());
        return cipher.doFinal(message);
    }

    static byte[] decrypt(PrivateKey privateKey, byte[] data) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    static byte[] sign(PrivateKey privateKey, X509Certificate certificate, byte[] message)
            throws GeneralSecurityException {
        Signature signature = Signature.getInstance(certificate.getSigAlgName());
        signature.initSign(privateKey);
        signature.update(message);
        return signature.sign();
    }

    static boolean verify(X509Certificate certificate, byte[] message, byte[] sig) throws GeneralSecurityException {
        Signature signature = Signature.getInstance(certificate.getSigAlgName());
        signature.initVerify(certificate);
        signature.update(message);
        return signature.verify(sig);
    }

    /***
     * 在上述代码中，我们从key store直接读取了私钥-公钥对，
     * 私钥以PrivateKey实例表示，公钥以X509Certificate表示，
     * 实际上数字证书只包含公钥，因此，读取证书并不需要口令，只有读取私钥才需要。
     * 如果部署到Web服务器上，例如Nginx，需要把私钥导出为Private Key格式，把证书导出为X509Certificate格式。
     *
     * 以HTTPS协议为例，浏览器和服务器建立安全连接的步骤如下：
     *
     * 浏览器向服务器发起请求，服务器向浏览器发送自己的数字证书；
     * 浏览器用操作系统内置的Root CA来验证服务器的证书是否有效，如果有效，就使用该证书加密一个随机的AES口令并发送给服务器；
     * 服务器用自己的私钥解密获得AES口令，并在后续通讯中使用AES加密。
     * 上述流程只是一种最常见的单向验证。如果服务器还要验证客户端，那么客户端也需要把自己的证书发送给服务器验证，这种场景常见于网银等。
     *
     * 数字证书存储的是公钥，以及相关的证书链和算法信息。私钥必须严格保密，如果数字证书对应的私钥泄漏，就会造成严重的安全威胁。如果CA证书的私钥泄漏，
     * 那么该CA证书签发的所有证书将不可信。
     * 数字证书服务商DigiNotar就发生过私钥泄漏导致公司破产的事故。
     * */
}
