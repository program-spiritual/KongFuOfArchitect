package useProperties;

import java.io.IOException;
import java.util.Properties;
/**
 * 也可以从classpath读取.properties文件，因为load(InputStream)方法接收一个InputStream实例，
 * 表示一个字节流，它不一定是文件流，也可以是从jar包中读取的资源流：
 *
 * Properties props = new Properties();
 * props.load(getClass().getResourceAsStream("/common/setting.properties"));
 *
 * */
public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(Main.class.getResourceAsStream("./setting.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filepath = props.getProperty("last_open_file");
        System.out.println(filepath);
        String interval = props.getProperty("auto_save_interval", "120");
        System.out.println(interval);

    }
}
