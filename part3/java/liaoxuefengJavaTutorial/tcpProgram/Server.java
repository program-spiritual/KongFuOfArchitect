package tcpProgram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

  public static void main(String[] args) {
    ServerSocket ss = null; // 监听指定端口

    try {
      ss = new ServerSocket(6666);
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

class Handler extends Thread {

  Socket sock;

  public Handler(Socket sock) {
    this.sock = sock;
  }

  @Override
  public void run() {
    try (InputStream input = this.sock.getInputStream()) {
      try (OutputStream output = this.sock.getOutputStream()) {
        handle(input, output);
      }
    } catch (Exception e) {
      try {
        this.sock.close();
      } catch (IOException ioe) {}

      System.out.println("client disconnected.");
    }
  }

  private void handle(InputStream input, OutputStream output)
    throws IOException {
    var writer = new BufferedWriter(
      new OutputStreamWriter(output, StandardCharsets.UTF_8)
    );
    var reader = new BufferedReader(
      new InputStreamReader(input, StandardCharsets.UTF_8)
    );

    writer.write("hello\n");
    writer.flush();

    for (;;) {
      String s = reader.readLine();

      if (s.equals("bye")) {
        writer.write("bye\n");
        /**
         * 如果不调用flush()，我们很可能会发现，客户端和服务器都收不到数据，这并不是Java标准库的设计问题，
         * 而是我们以流的形式写入数据的时候，并不是一写入就立刻发送到网络，而是先写入内存缓冲区，
         * 直到缓冲区满了以后，才会一次性真正发送到网络，这样设计的目的是为了提高传输效率。
         * 如果缓冲区的数据很少，而我们又想强制把这些数据发送到网络，
         * 就必须调用flush()强制把缓冲区数据发送出去。
         * */
        writer.flush();
        break;
      }

      writer.write("ok: " + s + "\n");
      writer.flush();
    }
  }
}
