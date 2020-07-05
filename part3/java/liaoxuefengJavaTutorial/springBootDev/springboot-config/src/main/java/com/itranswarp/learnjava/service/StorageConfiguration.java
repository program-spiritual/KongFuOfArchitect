package com.itranswarp.learnjava.service;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("storage.local")
public class StorageConfiguration {

	private String rootDir;
	private int maxSize;
	private boolean allowEmpty;
	private List<String> allowTypes;

	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public boolean isAllowEmpty() {
		return allowEmpty;
	}

	public void setAllowEmpty(boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
	}

	public List<String> getAllowTypes() {
		return allowTypes;
	}

	public void setAllowTypes(List<String> allowTypes) {
		this.allowTypes = allowTypes;
	}
}
