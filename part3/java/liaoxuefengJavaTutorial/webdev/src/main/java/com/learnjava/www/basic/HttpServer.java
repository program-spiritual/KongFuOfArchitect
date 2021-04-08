package com.learnjava.www.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

  public static void main(String[] args) {
    ServerSocket ss = null; // 监听指定端口
    try {
      ss = new ServerSocket(8080);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("server is running...");
    for (;;) {
      Socket sock = null;
      try {
        sock = ss.accept();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("connected from " + sock.getRemoteSocketAddress());
      Thread t = new Handler(sock);
      t.start();
    }
  }
}
