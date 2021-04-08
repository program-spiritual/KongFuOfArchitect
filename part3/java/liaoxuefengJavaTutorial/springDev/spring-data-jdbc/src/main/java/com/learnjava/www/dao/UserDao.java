package com.learnjava.www.dao;

import com.learnjava.www.service.User;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserDao extends AbstractDao {

  public User getById(long id) {
    return getJdbcTemplate()
      .queryForObject(
        "SELECT * FROM users WHERE id = ?",
        new BeanPropertyRowMapper<>(User.class),
        id
      );
  }
}
