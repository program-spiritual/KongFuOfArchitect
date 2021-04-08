package com.learnjava.www.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/upload/file")
public class UploadServlet extends HttpServlet {

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    // 读取Request Body:
    InputStream input = req.getInputStream();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    for (;;) {
      int len = input.read(buffer);
      if (len == -1) {
        break;
      }
      output.write(buffer, 0, len);
    }
    // TODO: 写入文件:
    // 显示上传结果:
    String uploadedText = output.toString(
      String.valueOf(StandardCharsets.UTF_8)
    );
    PrintWriter pw = resp.getWriter();
    pw.write("<h1>Uploaded:</h1>");
    pw.write("<pre><code>");
    pw.write(uploadedText);
    pw.write("</code></pre>");
    pw.flush();
  }
}
