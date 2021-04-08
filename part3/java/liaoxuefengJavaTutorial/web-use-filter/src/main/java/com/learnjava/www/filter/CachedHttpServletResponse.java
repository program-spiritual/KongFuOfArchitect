package com.learnjava.www.filter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CachedHttpServletResponse extends HttpServletResponseWrapper {

  private boolean open = false;
  private ByteArrayOutputStream output = new ByteArrayOutputStream();
  private byte[] content;

  public CachedHttpServletResponse(HttpServletResponse response) {
    super(response);
  }

  // 获取Writer:
  public PrintWriter getWriter() throws IOException {
    if (open) {
      throw new IllegalStateException("Cannot re-open writer!");
    }
    open = true;
    PrintWriter printWriter = new PrintWriter(
      output,
      false,
      StandardCharsets.UTF_8
    );
    return printWriter;
  }

  // 获取OutputStream:
  public ServletOutputStream getOutputStream() throws IOException {
    if (open) {
      throw new IllegalStateException("Cannot re-open output stream!");
    }
    open = true;
    return new ServletOutputStream() {
      public boolean isReady() {
        return true;
      }

      public void setWriteListener(WriteListener listener) {}

      // 实际写入ByteArrayOutputStream:
      public void write(int b) throws IOException {
        output.write(b);
      }
    };
  }

  public byte[] getContent() {
    return content;
  }
}
