package com.itranswarp.learnjava;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Main {

  public static void main(String[] args) {
    // 启动Tomcat:
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(Integer.getInteger("port", 8080));
    tomcat.getConnector();
    // 创建webapp:
    Context ctx = tomcat.addWebapp(
      "",
      new File("src/main/webapp").getAbsolutePath()
    );
    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(
      new DirResourceSet(
        resources,
        "/WEB-INF/classes",
        new File("target/classes").getAbsolutePath(),
        "/"
      )
    );
    ctx.setResources(resources);
    try {
      tomcat.start();
    } catch (LifecycleException e) {
      e.printStackTrace();
    }
    tomcat.getServer().await();
  }
}
