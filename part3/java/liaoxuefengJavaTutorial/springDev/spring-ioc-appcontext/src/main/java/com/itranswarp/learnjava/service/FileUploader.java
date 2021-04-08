package com.itranswarp.learnjava.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
  name = "app.storage",
  havingValue = "file",
  matchIfMissing = true
)
public class FileUploader implements Uploader {}
