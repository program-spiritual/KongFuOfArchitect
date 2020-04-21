import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class CommonToolsDemo4 {
    public static void main(String[] args) {
//        有伪随机数，就有真随机数。实际上真正的真随机数只能通过量子力学原理来获取，而我们想要的是一个不可预测的安全的随机数，SecureRandom就是用来创建安全的随机数的：
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));

        SecureRandom sr2 = null;
        try {
            sr2 = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr2 = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr2.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));

//        SecureRandom的安全性是通过操作系统提供的安全的随机种子来生成随机数。这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”。
//
//在密码学中，安全的随机数非常重要。如果使用不安全的伪随机数，所有加密体系都将被攻破。因此，时刻牢记必须使用SecureRandom来产生安全的随机数。
//        需要使用安全随机数的时候，必须使用SecureRandom，绝不能使用Random！
    }
}

/*
*
SecureRandom无法指定种子，它使用RNG（random number generator）算法。
* JDK的SecureRandom实际上有多种不同的底层实现，
* 有的使用安全随机种子加上伪随机数算法来产生安全的随机数，
* 有的使用真正的随机数生成器。
* 实际使用的时候，可以优先获取高强度的安全随机数生成器，
* 如果没有提供，再使用普通等级的安全随机数生成器：
* */
