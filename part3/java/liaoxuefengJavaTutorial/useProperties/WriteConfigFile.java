package useProperties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteConfigFile {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        try {
            props.store(new FileOutputStream("C:\\setting.properties"), "这是写入的properties注释");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
