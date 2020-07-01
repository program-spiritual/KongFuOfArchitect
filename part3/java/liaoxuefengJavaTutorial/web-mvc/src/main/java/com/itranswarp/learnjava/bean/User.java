package com.itranswarp.learnjava.bean;

public class User {

	public String email;
	public String password;

	public String name;
	public String description;

	public User() {
	}

	public User(String email, String password, String name, String description) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.description = description;
	}
}
