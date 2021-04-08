package com.learnjava.www.createPatterns.builder.mimeMessage;

public class MimeMessage {

  private Multipart content;

  public MimeMessage(Object session) {}

  public void setFrom(InternetAddress internetAddress) {}

  public void setRecipient(Object to, InternetAddress internetAddress) {}

  public void setSubject(String hello, String s) {}

  public void setContent(Multipart content) {
    this.content = content;
  }
}
