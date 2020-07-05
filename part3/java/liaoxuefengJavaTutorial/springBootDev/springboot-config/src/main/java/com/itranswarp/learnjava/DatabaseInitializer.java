package com.itranswarp.learnjava;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void init() {
		jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users (" //
				+ "id BIGINT IDENTITY NOT NULL PRIMARY KEY, " //
				+ "email VARCHAR(100) NOT NULL, " //
				+ "password VARCHAR(100) NOT NULL, " //
				+ "name VARCHAR(100) NOT NULL, " //
				+ "createdAt BIGINT NOT NULL, " //
				+ "UNIQUE (email))");
	}
}
