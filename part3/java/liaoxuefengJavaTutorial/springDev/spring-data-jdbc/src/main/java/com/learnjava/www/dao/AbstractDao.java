package com.learnjava.www.dao;

import java.lang.reflect.Parameter;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public abstract class AbstractDao<T> extends JdbcDaoSupport {

  private String table;
  private Class<T> entityClass;
  private RowMapper<T> rowMapper;
  private Class<T> parameterizedType;

  public AbstractDao() {
    // 获取当前类型的泛型类型:
    this.entityClass = getParameterizedType();
    this.table = this.entityClass.getSimpleName().toLowerCase() + "s";
    this.rowMapper = new BeanPropertyRowMapper<>(entityClass);
  }

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @PostConstruct
  public void init() {
    super.setJdbcTemplate(jdbcTemplate);
  }

  public Class<T> getParameterizedType() {
    return parameterizedType;
  }

  public T getById(long id) {
    return getJdbcTemplate()
      .queryForObject(
        "SELECT * FROM " + table + " WHERE id = ?",
        this.rowMapper,
        id
      );
  }

  public List<T> getAll(int pageIndex) {
    int limit = 100;
    int offset = limit * (pageIndex - 1);
    return getJdbcTemplate()
      .query(
        "SELECT * FROM " + table + " LIMIT ? OFFSET ?",
        new Object[] { limit, offset },
        this.rowMapper
      );
  }

  public void deleteById(long id) {
    getJdbcTemplate().update("DELETE FROM " + table + " WHERE id = ?", id);
  }
}
