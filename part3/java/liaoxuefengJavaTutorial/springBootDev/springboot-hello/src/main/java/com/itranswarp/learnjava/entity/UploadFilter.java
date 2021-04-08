package com.itranswarp.learnjava.entity;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;

public class UploadFilter {

  @Value("{storage.local.max-size:100000}")
  int maxSize;
}
