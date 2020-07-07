package com.itranswarp.learnjava.service;

import com.itranswarp.learnjava.bean.StorageConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

public interface StorageService {
    // 根据URI打开InputStream:
    InputStream openInputStream(String uri) throws IOException;

    // 根据扩展名+InputStream保存并返回URI:
    String store(String extName, InputStream input) throws IOException;

    final Logger logger = LoggerFactory.getLogger(StorageService.class);

    @Autowired
    ThreadLocal<StorageConfiguration> storageConfig = new ThreadLocal<StorageConfiguration>();

    @PostConstruct
    public default void init() {
        logger.info("Load configuration: root-dir = {}", storageConfig.get().getRootDir());
        logger.info("Load configuration: max-size = {}", storageConfig.get().getMaxSize());
        logger.info("Load configuration: allowed-types = {}", storageConfig.get().getAllowTypes());
    }
}
