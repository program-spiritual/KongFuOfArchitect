package useProperties;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ReadFromMem {
    public static void main(String[] args) {
        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
        ByteArrayInputStream input = null;
        try {
            input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Properties props = new Properties();
        try {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("course: " + props.getProperty("course"));
        System.out.println("last_open_date: " + props.getProperty("last_open_date"));
        System.out.println("last_open_file: " + props.getProperty("last_open_file"));
        System.out.println("auto_save: " + props.getProperty("auto_save", "60"));

//        如果有多个.properties文件，可以反复调用load()读取，后读取的key-value会覆盖已读取的key-value：
    }
}
