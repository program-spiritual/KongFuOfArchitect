package com.learnjava.www.createPatterns.builder.mimeMessage;

public interface BodyPart {
    void setContent(String body, String charset);

    void setFileName(String fileName);

    void setDataHandler();
}
