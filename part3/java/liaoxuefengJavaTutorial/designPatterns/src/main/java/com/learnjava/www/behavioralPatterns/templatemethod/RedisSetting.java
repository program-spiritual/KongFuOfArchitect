package com.learnjava.www.behavioralPatterns.templatemethod;

public class RedisSetting extends AbstractSetting {

  private RedisClient client = RedisClient.create("redis://localhost:6379");

  @Override
  protected String readFromDatabase(String key) {
    return null;
  }

  @Override
  protected String lookupCache(String key) {
    try {
      try (AutoCloseable connection = client.connect()) {
        RedisCommands<String, String> commands =
          ((StatefulRedisConnection) connection).sync();
        return commands.get(key);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return key;
  }

  @Override
  protected void putIntoCache(String key, String value) {
    try {
      try (
        StatefulRedisConnection<String, String> connection = client.connect()
      ) {
        RedisCommands<String, String> commands = connection.sync();
        commands.set(key, value);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
