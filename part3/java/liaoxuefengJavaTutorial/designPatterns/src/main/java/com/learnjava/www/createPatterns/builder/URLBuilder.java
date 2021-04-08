package com.learnjava.www.createPatterns.builder;

import java.util.HashMap;
import java.util.Map;

public class URLBuilder {

  private String domain;
  private String scheme;
  private String path;
  private Map<String, String> query = new HashMap<>();

  static URLBuilder builder() {
    return new URLBuilder();
  }

  URLBuilder setDomain(String domain) {
    this.domain = domain;
    return this;
  }

  URLBuilder setScheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  URLBuilder setPath(String path) {
    this.path = path;
    return this;
  }

  URLBuilder setQuery(Map<String, String> query) {
    this.query.putAll(query);
    return this;
  }

  String build() {
    StringBuilder sb = new StringBuilder();
    sb.append(scheme).append("://").append(domain);
    if (path != null) {
      sb.append(path);
    }
    if (!query.isEmpty()) {
      sb.append("?");
      for (String key : query.keySet()) {
        sb.append(key).append("=").append(query.get(key)).append("&");
      }
      return sb.substring(0, sb.length() - 1);
    }
    return sb.toString();
  }
}
