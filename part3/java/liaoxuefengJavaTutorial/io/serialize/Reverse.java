package io.serialize;

import java.io.*;
import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        //序列化
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            try (ObjectOutputStream os = new ObjectOutputStream(buffer)) {
                try {
                    os.writeInt(12345);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os.writeUTF("Hello");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os.writeObject(Double.valueOf(123.456));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        ByteArrayInputStream bufferin = new ByteArrayInputStream(buffer.toByteArray());
        //反序列化,反序列化时，由JVM直接构造出Java对象，不调用构造方法，构造方法内部的代码，在反序列化时根本不可能执行
        try {
            try (ObjectInputStream in = new ObjectInputStream(bufferin)) {
                int n = in.readInt();
                String s = in.readUTF();
                Double d = (Double) (in.readObject());
                System.out.println(n);
                System.out.println(s);
                System.out.println(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
