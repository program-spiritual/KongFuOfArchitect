package com.learnjava.www.behavioralPatterns.templatemethod;

public class StatefulRedisConnection<T, T1> implements AutoCloseable {
    public RedisCommands<T1, T1> sync() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
