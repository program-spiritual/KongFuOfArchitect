package com.learnjava.www.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

  // 在此初始化WebApp,例如打开数据库连接池等:
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("WebApp initialized.");
  }

  // 在此清理WebApp,例如关闭数据库连接池等:
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("WebApp destroyed.");
  }
}
