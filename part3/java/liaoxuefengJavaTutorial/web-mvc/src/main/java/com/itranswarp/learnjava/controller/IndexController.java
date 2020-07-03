package com.itranswarp.learnjava.controller;

import javax.servlet.http.HttpSession;

import com.itranswarp.learnjava.bean.User;
import com.itranswarp.learnjava.framework.GetMapping;
import com.itranswarp.learnjava.framework.ModelAndView;

public class IndexController {

	@GetMapping("/")
	public ModelAndView index(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return new ModelAndView("/index.html", "user", user);
	}

	@GetMapping("/hello")
	public ModelAndView hello(String name) {
		if (name == null) {
			name = "World";
		}
		return new ModelAndView("/hello.html", "name", name);
	}
}
