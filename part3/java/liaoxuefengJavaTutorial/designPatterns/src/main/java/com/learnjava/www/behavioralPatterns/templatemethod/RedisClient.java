package com.learnjava.www.behavioralPatterns.templatemethod;

public class RedisClient {

  public static RedisClient create(String s) {
    return null;
  }

  public StatefulRedisConnection<String, String> connect() {
    return new StatefulRedisConnection<>();
  }
}
