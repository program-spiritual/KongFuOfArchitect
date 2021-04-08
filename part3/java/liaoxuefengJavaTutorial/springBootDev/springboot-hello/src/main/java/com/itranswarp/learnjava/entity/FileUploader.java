package com.itranswarp.learnjava.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileUploader {

  @Value("{storage.local.max-size:102400}")
  int maxSize;
}
