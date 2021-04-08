package com.learnjava.www.structPatterns.proxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;
import javax.sql.PooledConnection;

public class PooledConnectionProxy extends AbstractConnectionProxy {

  Connection target;
  Queue<PooledConnectionProxy> idleQueue;

  public PooledConnectionProxy(
    Connection target,
    Queue<PooledConnectionProxy> idleQueue
  ) {
    this.target = target;
    this.idleQueue = idleQueue;
  }

  @Override
  public void close() throws SQLException {
    System.out.println(
      "Fake close and released to idle queue for future reuse: " + target
    );
    // 并没有调用实际Connection的close()方法,
    // 而是把自己放入空闲队列:
    idleQueue.offer(this);
  }

  protected Connection getRealConnection() {
    return target;
  }
}
