package encryptionAndSecurity.urlEncode;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    //    例如：字符中的UTF-8编码是0xe4b8ad，因此，它的URL编码是%E4%B8%AD。URL编码总是大写。
    //    Java标准库提供了一个URLEncoder类来对任意字符串进行URL编码：
    public static void main(String[] args) {
        String encoded = URLEncoder.encode("中文!", StandardCharsets.UTF_8);
        System.out.println(encoded);
//       上述代码的运行结果是%E4%B8%AD%E6%96%87%21，
//       中的URL编码是%E4%B8%AD，
//       文的URL编码是%E6%96%87，
//       !虽然是ASCII字符，也要对其编码为%21。
//       要特别注意：URL编码是编码算法，不是加密算法。
//       URL编码的目的是把任意文本数据编码为%前缀表示的文本，
//       编码后的文本仅包含A~Z，a~z，0~9，-，_，.，*和%，便于浏览器和服务器处理。

//       和标准的URL编码稍有不同，URLEncoder把空格字符编码成+，
//       而现在的URL编码标准要求空格被编码为%20，不过，服务器都可以处理这两种情况。
//       如果服务器收到URL编码的字符串，就可以对其进行解码，还原成原始字符串。Java标准库的URLDecoder就可以解码：
        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
