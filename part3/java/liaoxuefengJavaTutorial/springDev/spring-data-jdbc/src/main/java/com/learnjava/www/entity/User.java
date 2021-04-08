package com.learnjava.www.entity;

import javax.persistence.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@NamedQueries(
  @NamedQuery(
    // 查询名称:
    name = "login",
    // 查询语句:
    query = "SELECT u FROM User u WHERE u.email=?0 AND u.password=?1"
  )
)
@Entity
public class User extends AbstractEntity {

  private String email;
  private String password;
  private String name;
  private SessionFactory sessionFactory;

  @Column(nullable = false, unique = true, length = 100)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(nullable = false, length = 100)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  void operation() {
    Session session = null;
    boolean isNew = false;
    // 获取当前Session或者打开新的Session:
    try {
      session = this.sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
      session = this.sessionFactory.openSession();
      isNew = true;
    }
    // 操作Session:
    try {
      com.learnjava.www.service.User user = session.load(
        com.learnjava.www.service.User.class,
        123L
      );
    } finally {
      // 关闭新打开的Session:
      if (isNew) {
        session.close();
      }
    }
  }
}
