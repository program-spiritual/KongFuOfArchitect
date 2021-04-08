package encryptionAndSecurity.base64Encode;

import java.util.Arrays;
import java.util.Base64;

public class ForUrl {

  public static void main(String[] args) {
    //        一种针对URL的Base64编码可以在URL中使用的Base64编码，它仅仅是把+变成-，/变成_：
    byte[] input = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
    String b64encoded = Base64.getUrlEncoder().encodeToString(input);
    System.out.println(b64encoded);
    byte[] output = Base64.getUrlDecoder().decode(b64encoded);
    System.out.println(Arrays.toString(output));
    //        Base64编码的缺点是传输效率会降低，因为它把原始数据的长度增加了1/3。
    //
    //和URL编码一样，Base64编码是一种编码算法，不是加密算法。
  }
}
