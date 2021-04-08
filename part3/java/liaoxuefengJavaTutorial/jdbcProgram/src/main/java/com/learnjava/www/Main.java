package com.learnjava.www;

import java.sql.*;

public class Main {

  static final String JDBC_URL =
    "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
  static final String JDBC_USER = "root";
  static final String JDBC_PASSWORD = "123456";

  public static void main(String[] args) {
    // JDBC连接的URL, 不同数据库有不同的格式:

    // 获取连接:
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    // TODO: 访问数据库...
    // 关闭连接:
    try {
      conn.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    queryFromMysql();
  }

  static void queryFromMysql() {
    try {
      try (
        Connection conn = DriverManager.getConnection(
          JDBC_URL,
          JDBC_USER,
          JDBC_PASSWORD
        )
      ) {
        try (Statement stmt = conn.createStatement()) {
          try (
            ResultSet rs = stmt.executeQuery(
              "SELECT id, grade, name, gender FROM students WHERE gender=1"
            )
          ) {
            while (rs.next()) {
              long id = rs.getLong(1); // 注意：索引从1开始
              long grade = rs.getLong(2);
              String name = rs.getString(3);
              int gender = rs.getInt(4);
            }
          }
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  static void selectDemo() {
    try {
      try (
        Connection conn = DriverManager.getConnection(
          JDBC_URL,
          JDBC_USER,
          JDBC_PASSWORD
        )
      ) {
        try (
          PreparedStatement ps = conn.prepareStatement(
            "SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?"
          )
        ) {
          ps.setObject(1, "M"); // 注意：索引从1开始
          ps.setObject(2, 3);
          try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
              long id = rs.getLong("id");
              long grade = rs.getLong("grade");
              String name = rs.getString("name");
              String gender = rs.getString("gender");
            }
          }
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  //   插入数据
  static void doInsertInto() {
    try {
      try (
        Connection conn = DriverManager.getConnection(
          JDBC_URL,
          JDBC_USER,
          JDBC_PASSWORD
        )
      ) {
        try (
          PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO students (id, grade, name, gender) VALUES (?,?,?,?)"
          )
        ) {
          ps.setObject(1, 999); // 注意：索引从1开始
          ps.setObject(2, 1); // grade
          ps.setObject(3, "Bob"); // name
          ps.setObject(4, "M"); // gender
          int n = ps.executeUpdate(); // 1
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  //   插入数据并获取主键

  static void doInsertIntoAndGetPrimaryKey() {
    try {
      try (
        Connection conn = DriverManager.getConnection(
          JDBC_URL,
          JDBC_USER,
          JDBC_PASSWORD
        )
      ) {
        //                获取自增主键的正确写法是在创建PreparedStatement的时候，指定一个RETURN_GENERATED_KEYS标志位，
        //               表示JDBC驱动必须返回插入的自增主键。示例代码如下：
        try (
          PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO students (grade, name, gender) VALUES (?,?,?)",
            Statement.RETURN_GENERATED_KEYS
          )
        ) {
          ps.setObject(1, 1); // grade
          ps.setObject(2, "Bob"); // name
          ps.setObject(3, "M"); // gender
          int n = ps.executeUpdate(); // 1
          try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
              long id = rs.getLong(1); // 注意：索引从1开始
            }
          }
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  //    更新
  static void doUpdate() {
    try {
      try (
        Connection conn = DriverManager.getConnection(
          JDBC_URL,
          JDBC_USER,
          JDBC_PASSWORD
        )
      ) {
        try (
          PreparedStatement ps = conn.prepareStatement(
            "UPDATE students SET name=? WHERE id=?"
          )
        ) {
          ps.setObject(1, "Bob"); // 注意：索引从1开始
          ps.setObject(2, 999);
          int n = ps.executeUpdate(); // 返回更新的行数
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  //    删除
  static void doDelete() {
    try {
      try (
        Connection conn = DriverManager.getConnection(
          JDBC_URL,
          JDBC_USER,
          JDBC_PASSWORD
        )
      ) {
        try (
          PreparedStatement ps = conn.prepareStatement(
            "DELETE FROM students WHERE id=?"
          )
        ) {
          ps.setObject(1, 999); // 注意：索引从1开始
          int n = ps.executeUpdate(); // 删除的行数
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  //    处理事务

  static void doTransactions() {
    try {
      try (
        Connection conn = DriverManager.getConnection(
          JDBC_URL,
          JDBC_USER,
          JDBC_PASSWORD
        )
      ) {
        try {
          // 关闭自动提交:
          conn.setAutoCommit(false);
          // 执行多条SQL语句:
          //                    insert(); update(); delete();
          // 提交事务:
          conn.commit();
        } catch (SQLException e) {
          // 回滚事务:
          conn.rollback();
        } finally {
          conn.setAutoCommit(true);
          conn.close();
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  //    处理批量事务
  static void doBatch() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      try (
        PreparedStatement ps = conn.prepareStatement(
          "INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)"
        )
      ) {
        // 对同一个PreparedStatement反复设置参数并调用addBatch():
        String[] names = new String[0];
        boolean gender = false;
        int grade = 3;
        int score = 99;
        for (String name : names) {
          ps.setString(1, name);
          ps.setBoolean(2, gender);
          ps.setInt(3, grade);
          ps.setInt(4, score);
          ps.addBatch(); // 添加到batch
        }
        // 执行batch:
        int[] ns = ps.executeBatch();
        for (int n : ns) {
          System.out.println(n + " inserted."); // batch中每个SQL执行的结果数量
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
