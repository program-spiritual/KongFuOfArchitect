package com.learnjava.www.createPatterns.builder.mimeMessage;

public class Main {

  public static void main(String[] args) {
    Multipart multipart = new MimeMultipart();
    // 添加text:
    BodyPart textpart = new MimeBodyPart();
    String body = "";
    String fileName = "";
    textpart.setContent(body, "text/html;charset=utf-8");
    multipart.addBodyPart(textpart);
    // 添加image:
    BodyPart imagepart = new MimeBodyPart();
    imagepart.setFileName(fileName);
    Object input = new Object();
    imagepart.setDataHandler();
    multipart.addBodyPart(imagepart);

    Object session = new Object();
    MimeMessage message = new MimeMessage(session);
    // 设置发送方地址:
    message.setFrom(new InternetAddress("me@example.com"));
    // 设置接收方地址:
    message.setRecipient(
      Message.RecipientType.TO,
      new InternetAddress("xiaoming@somewhere.com")
    );
    // 设置邮件主题:
    message.setSubject("Hello", "UTF-8");
    // 设置邮件内容为multipart:
    message.setContent(multipart);
  }
}
