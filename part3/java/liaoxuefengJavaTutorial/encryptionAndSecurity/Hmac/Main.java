package encryptionAndSecurity.Hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * HmacMD5可以看作带有一个安全的key的MD5。使用HmacMD5而不是用MD5加salt，有如下好处：
 *
 * HmacMD5使用的key长度是64字节，更安全；
 * Hmac是标准算法，同样适用于SHA-1等其他哈希算法；
 * Hmac输出和原有的哈希算法长度一致。
 *
 *和MD5相比，使用HmacMD5的步骤是：
 *
 * 通过名称HmacMD5获取KeyGenerator实例；
 * 通过KeyGenerator创建一个SecretKey实例；
 * 通过名称HmacMD5获取Mac实例；
 * 用SecretKey初始化Mac实例；
 * 对Mac实例反复调用update(byte[])输入数据；
 * 调用Mac实例的doFinal()获取最终的哈希值。
 * 我们可以用Hmac算法取代原有的自定义的加盐算法，因此，存储用户名和口令的数据库结构如下：
 *
 username	secret_key (64 bytes)	password
 bob	a8c06e05f92e...5e16	7e0387872a57c85ef6dddbaa12f376de
 alice	e6a343693985...f4be	c1f929ac2552642b302e739bc0cdbaac
 tim	f27a973dfdc0...6003	af57651c3a8a73303515804d4af43790
 * */
public class Main {
    public static void main(String[] args) {
/**
 * 为了保证安全，我们不会自己指定key，而是通过Java标准库的KeyGenerator生成一个安全的随机的key。下面是使用HmacMD5的代码
 *
 * */
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("HmacMD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey key = keyGen.generateKey();
        // 打印随机生成的key:
        byte[] skey = key.getEncoded();
        System.out.println(new BigInteger(1, skey).toString(16));
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacMD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            mac.init(key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            mac.update("HelloWorld".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
