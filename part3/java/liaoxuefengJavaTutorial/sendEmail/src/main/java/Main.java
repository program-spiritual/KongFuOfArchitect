import javafx.embed.swing.SwingNode;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // 服务器地址:
        String smtp = "smtp.qq.com";
// 登录用户名:
        final String username = "jxsmtp101@outlook.com";
// 登录口令:
        final String password = "********";
// 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "587"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
// 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
// 设置debug模式便于调试:
        session.setDebug(true);

//        sendTextEmail(session);
    }

    // 发送文本邮件
    static void sendTextEmail(Session session) {
        MimeMessage message = new MimeMessage(session);
// 设置发送方地址:
        try {
            message.setFrom(new InternetAddress("me@example.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 设置接收方地址:
        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("xiaoming@somewhere.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 设置邮件主题:
        try {
            message.setSubject("Hello", "UTF-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 设置邮件正文:
        try {
            message.setText("Hi Xiaoming...", "UTF-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 发送:
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    //    发送HTML文件
    static void sendHtmlEmail(Session session) {
        MimeMessage message = new MimeMessage(session);
// 设置发送方地址:
        try {
            message.setFrom(new InternetAddress("me@example.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 设置接收方地址:
        try {
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("xiaoming@somewhere.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 设置邮件主题:
        try {
            message.setSubject("Hello", "UTF-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 设置邮件正文:
        try {
            message.setText("<h1>Hello</h1><p>Hi, xxx</p>", "UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 发送:
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    //    发送附件
    static void sendFile(Session session) {
        MimeMessage message = new MimeMessage(session);
        Multipart multipart = new MimeMultipart();
// 添加text:
        BodyPart textpart = new MimeBodyPart();
        Object body = new Object();
        try {
            textpart.setContent(body, "text/html;charset=utf-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            multipart.addBodyPart(textpart);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 添加image:
        BodyPart imagepart = new MimeBodyPart();
        String fileName = "";
        try {
            imagepart.setFileName(fileName);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        byte[] input = new byte[0];
        try {
            imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "application/octet-stream")));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            multipart.addBodyPart(imagepart);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
// 设置邮件内容为multipart:
        try {
            message.setContent(multipart);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

//    发送内嵌的HTML文件

   static void sendInnerHtmlFile(Session session) {
       Multipart multipart = new MimeMultipart();
// 添加text:
       BodyPart textpart = new MimeBodyPart();
       try {
           textpart.setContent("<h1>Hello</h1><p><img src=\"cid:img01\"></p>", "text/html;charset=utf-8");
       } catch (MessagingException e) {
           e.printStackTrace();
       }
       try {
           multipart.addBodyPart(textpart);
       } catch (MessagingException e) {
           e.printStackTrace();
       }
// 添加image:
       BodyPart imagepart = new MimeBodyPart();
       String fileName = "";
       try {
           imagepart.setFileName(fileName);
       } catch (MessagingException e) {
           e.printStackTrace();
       }
       byte[] input = new byte[0];
       try {
           imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "image/jpeg")));
       } catch (MessagingException e) {
           e.printStackTrace();
       }
// 与HTML的<img src="cid:img01">关联:
       try {
           imagepart.setHeader("Content-ID", "<img01>");
       } catch (MessagingException e) {
           e.printStackTrace();
       }
       try {
           multipart.addBodyPart(imagepart);
       } catch (MessagingException e) {
           e.printStackTrace();
       }
   }
}
