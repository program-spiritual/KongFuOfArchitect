package encryptionAndSecurity.base64Encode;

import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {

        /***************************************************************************************************************
         *
         * Base64编码是对二进制数据进行编码，表示成文本格式。
         *它的原理是把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串。
         * 例如：3个byte数据分别是e4、b8、ad，按6bit分组得到39、0b、22和2d
         * ┌───────────────┬───────────────┬───────────────┐
         * │      e4       │      b8       │      ad       │
         * └───────────────┴───────────────┴───────────────┘
         * ┌─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┬─┐
         * │1│1│1│0│0│1│0│0│1│0│1│1│1│0│0│0│1│0│1│0│1│1│0│1│
         * └─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┴─┘
         * ┌───────────┬───────────┬───────────┬───────────┐
         * │    39     │    0b     │    22     │    2d     │
         * └───────────┴───────────┴───────────┴───────────┘
         *因为6位整数的范围总是0~63，所以，能用64个字符表示：字符A~Z对应索引0~25，字符a~z对应索引26~51，
         * 字符0~9对应索引52~61，最后两个索引62、63分别用字符+和/表示。
         *
         * 在Java中，二进制数据就是byte[]数组。Java标准库提供了Base64来对byte[]数组进行编解码：
         **************************************************************************************************************/
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);

        /**************************************************************************************************************
         * 要对Base64解码，仍然用Base64这个类：
         ************************************************************************************************************* */
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]

        /**
         * 如果输入的byte[]数组长度不是3的整数倍肿么办？
         * 需要对输入的末尾补一个或两个0x00，编码后，在结尾加一个=表示补充了1个0x00，加两个=表示补充了2个0x00，
         * 解码的时候，去掉末尾补充的一个或两个0x00即可。
         *
         * 实际上，因为编码后的长度加上=总是4的倍数，所以即使不加=也可以计算出原始输入的byte[]。
         * Base64编码的时候可以用withoutPadding()去掉=，解码出来的结果是一样的：
         * */

        byte[] input1 = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21 };
        String b64encoded1 = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded1);
        System.out.println(b64encoded2);
        byte[] output1 = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output1));
    }
}
