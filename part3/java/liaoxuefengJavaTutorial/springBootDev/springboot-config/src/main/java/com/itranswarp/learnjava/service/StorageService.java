package com.itranswarp.learnjava.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StorageService {

	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	StorageConfiguration storageConfig;

	@PostConstruct
	public void init() {
		logger.info("Load configuration: root-dir = {}", storageConfig.getRootDir());
		logger.info("Load configuration: max-size = {}", storageConfig.getMaxSize());
		logger.info("Load configuration: allowed-types = {}", storageConfig.getAllowTypes());
	}
}
