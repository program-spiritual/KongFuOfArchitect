package com.learnjava.www.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService {

  @PersistenceContext
  EntityManager em;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  HibernateTemplate hibernateTemplate;

  public User getUserById(long id) {
    // 注意传入的是ConnectionCallback:
    return jdbcTemplate.execute(
      (Connection conn) -> {
        // 可以直接使用conn实例，不要释放它，回调结束后JdbcTemplate自动释放:
        // 在内部手动创建的PreparedStatement、ResultSet必须用try(...)释放:
        try (
          var ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?")
        ) {
          ps.setObject(1, id);
          try (var rs = ps.executeQuery()) {
            if (rs.next()) {
              return new User( // new User object:
                rs.getLong("id"), // id
                rs.getString("email"), // email
                rs.getString("password"), // password
                rs.getString("name")
              ); // name
            }
            throw new RuntimeException("user not found by id.");
          }
        }
      }
    );
  }

  public User getUserByName(String name) {
    // 需要传入SQL语句，以及PreparedStatementCallback:
    return jdbcTemplate.execute(
      "SELECT * FROM users WHERE name = ?",
      (PreparedStatement ps) -> {
        // PreparedStatement实例已经由JdbcTemplate创建，并在回调后自动释放:
        ps.setObject(1, name);
        try (var rs = ps.executeQuery()) {
          if (rs.next()) {
            return new User( // new User object:
              rs.getLong("id"), // id
              rs.getString("email"), // email
              rs.getString("password"), // password
              rs.getString("name")
            ); // name
          }
          throw new RuntimeException("user not found by id.");
        }
      }
    );
  }

  public User getUserByEmail(String email) {
    // 传入SQL，参数和RowMapper实例:
    return jdbcTemplate.queryForObject(
      "SELECT * FROM users WHERE email = ?",
      new Object[] { email },
      (ResultSet rs, int rowNum) -> {
        // 将ResultSet的当前行映射为一个JavaBean:
        return new User( // new User object:
          rs.getLong("id"), // id
          rs.getString("email"), // email
          rs.getString("password"), // password
          rs.getString("name")
        ); // name
      }
    );
  }

  public long getUsers() {
    return jdbcTemplate.queryForObject(
      "SELECT COUNT(*) FROM users",
      null,
      (ResultSet rs, int rowNum) -> {
        // SELECT COUNT(*)查询只有一列，取第一列数据:
        return rs.getLong(1);
      }
    );
  }

  public List<User> getUsers(int pageIndex) {
    int limit = 100;
    int offset = limit * (pageIndex - 1);
    return jdbcTemplate.query(
      "SELECT * FROM users LIMIT ? OFFSET ?",
      new Object[] { limit, offset },
      new BeanPropertyRowMapper<>(User.class)
    );
  }

  public void updateUser(Long id, String name) {
    User user = hibernateTemplate.load(User.class, id);
    user.setName(name);
    hibernateTemplate.update(user);
  }

  public boolean deleteUser(Long id) {
    User user = hibernateTemplate.get(User.class, id);
    if (user != null) {
      hibernateTemplate.delete(user);
      return true;
    }
    return false;
  }

  @Transactional
  public User register(String email, String password, String name) {
    // 创建一个User对象:
    User user = new User();
    // 设置好各个属性:
    user.setEmail(email);
    user.setPassword(password);
    user.setName(name);
    // 不要设置id，因为使用了自增主键
    // 保存到数据库:
    hibernateTemplate.save(user);
    // 现在已经自动获得了id:
    System.out.println(user.getId());
    return user;
  }

  public User login(String email, String password) {
    User example = new User();
    example.setEmail(email);
    example.setPassword(password);
    List<User> list = hibernateTemplate.findByExample(example);
    return list.isEmpty() ? null : list.get(0);
  }

  public User login2(String email, String password) {
    DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
    criteria
      .add(Restrictions.eq("email", email))
      .add(Restrictions.eq("password", password));
    List<User> list = (List<User>) hibernateTemplate.findByCriteria(criteria);
    return list.isEmpty() ? null : list.get(0);
  }

  public void criteriaDemo(String email, String password) {
    DetachedCriteria criteria = DetachedCriteria.forClass(User.class);

    criteria.add(
      Restrictions.and(
        Restrictions.or(
          Restrictions.eq("email", email),
          Restrictions.eq("name", email)
        ),
        Restrictions.eq("password", password)
      )
    );
  }

  public User login3(String email, String password) {
    List<User> list = (List<User>) hibernateTemplate.findByNamedQuery(
      "login",
      email,
      password
    );
    return list.isEmpty() ? null : list.get(0);
  }
}
