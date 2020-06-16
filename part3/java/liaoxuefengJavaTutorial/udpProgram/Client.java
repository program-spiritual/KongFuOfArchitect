package udpProgram;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            ds.setSoTimeout(1000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            ds.connect(InetAddress.getByName("localhost"), 6666); // 连接指定服务器和端口
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
// 发送:
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        try {
            ds.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
// 接收:
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        try {
            ds.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println(resp);
        ds.disconnect();
    }
}
