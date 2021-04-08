package encryptionAndSecurity.DiffieHellman;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import javax.crypto.KeyAgreement;

//DH算法是一个密钥协商算法，双方最终协商出一个共同的密钥，而这个密钥不会通过网络传输
//但是DH算法并未解决中间人攻击，即甲乙双方并不能确保与自己通信的是否真的是对方。
//消除中间人攻击需要其他方法。
public class Main {

  public static void main(String[] args) {
    /**
     * 如果我们把a看成甲的私钥，A看成甲的公钥，b看成乙的私钥，B看成乙的公钥，
     * DH算法的本质就是双方各自生成自己的私钥和公钥，私钥仅对自己可见，然后交换公钥，
     * 并根据自己的私钥和对方的公钥，生成最终的密钥secretKey，
     * DH算法通过数学定律保证了双方各自计算出的secretKey是相同的。
     *
     * */

    // Bob和Alice:
    Person bob = new Person("Bob");
    Person alice = new Person("Alice");

    // 各自生成KeyPair:
    bob.generateKeyPair();
    alice.generateKeyPair();

    // 双方交换各自的PublicKey:
    // Bob根据Alice的PublicKey生成自己的本地密钥:
    bob.generateSecretKey(alice.publicKey.getEncoded());
    // Alice根据Bob的PublicKey生成自己的本地密钥:
    alice.generateSecretKey(bob.publicKey.getEncoded());

    // 检查双方的本地密钥是否相同:
    bob.printKeys();
    alice.printKeys();
    // 双方的SecretKey相同，后续通信将使用SecretKey作为密钥进行AES加解密...
  }
}

class Person {

  public final String name;

  public PublicKey publicKey;
  private PrivateKey privateKey;
  private byte[] secretKey;

  public Person(String name) {
    this.name = name;
  }

  // 生成本地KeyPair:
  public void generateKeyPair() {
    try {
      KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
      kpGen.initialize(512);
      KeyPair kp = kpGen.generateKeyPair();
      this.privateKey = kp.getPrivate();
      this.publicKey = kp.getPublic();
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  public void generateSecretKey(byte[] receivedPubKeyBytes) {
    try {
      // 从byte[]恢复PublicKey:
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
      KeyFactory kf = KeyFactory.getInstance("DH");
      PublicKey receivedPublicKey = kf.generatePublic(keySpec);
      // 生成本地密钥:
      KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
      keyAgreement.init(this.privateKey); // 自己的PrivateKey
      keyAgreement.doPhase(receivedPublicKey, true); // 对方的PublicKey
      // 生成SecretKey密钥:
      this.secretKey = keyAgreement.generateSecret();
    } catch (GeneralSecurityException e) {
      throw new RuntimeException(e);
    }
  }

  public void printKeys() {
    System.out.printf("Name: %s\n", this.name);
    System.out.printf(
      "Private key: %x\n",
      new BigInteger(1, this.privateKey.getEncoded())
    );
    System.out.printf(
      "Public key: %x\n",
      new BigInteger(1, this.publicKey.getEncoded())
    );
    System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey));
  }
}
