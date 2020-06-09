package encryptionAndSecurity.Hmac;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SecretkeyRecovery {
    public static void main(String[] args) {

        byte[] hkey = new byte[]{
                106, 70, -110, 125, 39,
                -20, 52, 56, 85, 9, -19,
                -72, 52, -53, 52, -45,
                -6, 119, -63, 30, 20,
                -83, -28, 77, 98, 109,
                -32, -76, 121, -106, 0,
                -74, -107, -114, -45, 104,
                -104, -8, 2, 121, 6,
                97, -18, -13, -63, -30,
                -125, -103, -80, -46, 113,
                -14, 68, 32, -46, 101,
                -116, -104, -81, -108, 122,
                89, -106, -109
        };

//恢复SecretKey的语句就是new SecretKeySpec(hkey, "HmacMD5")。
        SecretKey key = new SecretKeySpec(hkey, "HmacMD5");
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
        System.out.println(Arrays.toString(result));
        // [126, 59, 37, 63, 73, 90, 111, -96, -77, 15, 82, -74, 122, -55, -67, 54]
    }
}
