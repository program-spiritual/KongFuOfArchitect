package com.learnjava.www.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/user/*")
public class AuthFilter implements Filter {

  @Override
  public void doFilter(
    ServletRequest servletRequest,
    ServletResponse servletResponse,
    FilterChain filterChain
  ) throws IOException, ServletException {
    System.out.println("AuthFilter: check authentication");
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    if (req.getSession().getAttribute("user") == null) {
      // 未登录，自动跳转到登录页:
      System.out.println("AuthFilter: not signin!");
      resp.sendRedirect("/signin");
    } else {
      // 已登录，继续处理:
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}
