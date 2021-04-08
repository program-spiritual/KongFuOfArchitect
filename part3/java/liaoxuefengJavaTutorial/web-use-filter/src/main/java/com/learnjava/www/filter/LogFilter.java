package com.learnjava.www.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LogFilter implements Filter {

  @Override
  public void doFilter(
    ServletRequest servletRequest,
    ServletResponse servletResponse,
    FilterChain filterChain
  ) throws IOException, ServletException {
    System.out.println(
      "LogFilter: process " +
      ((HttpServletRequest) servletRequest).getRequestURI()
    );
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
