package encryptionAndSecurity.symmetric;

/**
 * 从程序的角度看，所谓加密，就是这样一个函数，它接收密码和明文，然后输出密文：
 *
 * secret = encrypt(key, message);
 * 而解密则相反，它接收密码和密文，然后输出明文：
 *
 * plain = decrypt(key, secret);
 *
 *在软件开发中，常用的对称加密算法有：
 *
 * 算法	密钥长度	工作模式	填充模式
 * DES	56/64	ECB/CBC/PCBC/CTR/...	NoPadding/PKCS5Padding/...
 * AES	128/192/256	ECB/CBC/PCBC/CTR/...	NoPadding/PKCS5Padding/PKCS7Padding/...
 * IDEA	128	ECB	PKCS5Padding/PKCS7Padding/...
 *
 * */
public class Main {

  public static void main(String[] args) {}
}
