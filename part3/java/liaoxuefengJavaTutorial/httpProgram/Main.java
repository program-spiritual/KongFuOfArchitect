package httpProgram;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * 我们来看一下如何使用新版的HttpClient。首先需要创建一个全局HttpClient实例，
 * 因为HttpClient内部使用线程池优化多个HTTP连接，可以复用：
 * 如果我们要获取图片这样的二进制内容，只需要把HttpResponse.BodyHandlers.ofString()换成
 * HttpResponse.BodyHandlers.ofByteArray()，
 * 就可以获得一个HttpResponse<byte[]>对象。
 * 如果响应的内容很大，不希望一次性全部加载到内存，
 * 可以使用HttpResponse.BodyHandlers.ofInputStream()
 * 获取一个InputStream流。
 */
public class Main {

    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) {
        getMethod();
        postMethod();
    }

    static void getMethod() {
        String url = "https://www.sina.com.cn/";
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder(new URI(url))
                    // 设置Header:
                    .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
                    // 设置超时:
                    .timeout(Duration.ofSeconds(5))
                    // 设置版本:
                    .version(HttpClient.Version.HTTP_2).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // HTTP允许重复的Header，因此一个Header可对应多个Value:
        Map<String, List<String>> headers = response.headers().map();
        for (Object header : ((Map) headers).keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }
        System.out.println(response.body().substring(0, 1024) + "...");
    }

    static void postMethod() {
        String url = "http://www.example.com/login";
        String body = "username=bob&password=123456";
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder(new URI(url))
                    // 设置Header:
                    .header("Accept", "*/*")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    // 设置超时:
                    .timeout(Duration.ofSeconds(5))
                    // 设置版本:
                    .version(HttpClient.Version.HTTP_2)
                    // 使用POST并设置Body:
                    .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8)).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = response.body();
    }
}
