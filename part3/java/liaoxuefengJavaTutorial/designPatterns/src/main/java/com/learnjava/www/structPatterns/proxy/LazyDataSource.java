package com.learnjava.www.structPatterns.proxy;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class LazyDataSource implements DataSource {

  private String url;
  private String username;
  private String password;

  public LazyDataSource(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  @Override
  public Connection getConnection() throws SQLException {
    return null;
  }

  @Override
  public Connection getConnection(String username, String password)
    throws SQLException {
    return new LazyConnectionProxy(
      () -> {
        try {
          Connection conn = DriverManager.getConnection(
            url,
            username,
            password
          );
          System.out.println("Open connection: " + conn);
          return conn;
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    );
  }

  @Override
  public PrintWriter getLogWriter() throws SQLException {
    return null;
  }

  @Override
  public void setLogWriter(PrintWriter out) throws SQLException {}

  @Override
  public void setLoginTimeout(int seconds) throws SQLException {}

  @Override
  public int getLoginTimeout() throws SQLException {
    return 0;
  }

  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    return null;
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    return null;
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return false;
  }
}
