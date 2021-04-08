package com.learnjava.www.dao;

import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDaoSupport extends DaoSupport {

  @Override
  protected void checkDaoConfig() throws IllegalArgumentException {}

  private JdbcTemplate jdbcTemplate;

  public final void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    initTemplateConfig();
  }

  private void initTemplateConfig() {}

  public final JdbcTemplate getJdbcTemplate() {
    return this.jdbcTemplate;
  }
}
