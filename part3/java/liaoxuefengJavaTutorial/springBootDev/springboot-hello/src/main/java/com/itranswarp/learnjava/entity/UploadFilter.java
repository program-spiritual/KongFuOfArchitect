package com.itranswarp.learnjava.entity;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class UploadFilter {
    @Value("{storage.local.max-size:100000}")
    int maxSize;
}
