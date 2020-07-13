package io.outputstream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class OutputStreamDemo1 {
    public static void main(String[] args) {
        byte[] data = new byte[0];
        try {
            try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                output.write("Hello ".getBytes("UTF-8"));
                output.write("world!".getBytes("UTF-8"));
                data = output.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(new String(data, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
