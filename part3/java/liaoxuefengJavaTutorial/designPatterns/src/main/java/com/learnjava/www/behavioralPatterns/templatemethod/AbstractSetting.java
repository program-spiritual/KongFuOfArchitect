package com.learnjava.www.behavioralPatterns.templatemethod;

public abstract class AbstractSetting {

  public final String getSetting(String key) {
    String value = lookupCache(key);

    if (value == null) {
      value = readFromDatabase(key);
      putIntoCache(key, value);
    }

    return value;
  }

  protected abstract String readFromDatabase(String key);

  protected abstract String lookupCache(String key);

  protected abstract void putIntoCache(String key, String value);
}
