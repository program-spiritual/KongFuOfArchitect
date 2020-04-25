#web.xml配置文件作用

简单说是在SpringMvc框架下配置listener filter 和servlet的配置文件

### 1、<xml>标签

```xml
<?xml version="1.0" encoding="UTF-8"?>
```

注意点：当你复制的xml文件内容的时候一定要注意将这行内容放在文件的顶格第一行，在这之前不要出现空格

version表示的是当前xml的版本，encoding声明用xml传输数据的时候的字符编码



### 2、<web-app>标签

web.xml各版本头文件及与JDK、Tomcat版本对应关系:

​	**a、**web.xml——version2.2——JDK1.1——Tomcat3.3/ web.xml——version2.3——JDK1.3——Tomcat4.1

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>  
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">  
<web-app>  
</web-app>
```

​	**b、**web.xml——version2.4——JDK1.4——Tomcat5.5

```xml
<?xml version="1.0" encoding="UTF-8"?>  
<web-app id="WebApp_9" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee"   
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">  
</web-app>
```

  	**c、**web.xml——version2.5——JDK5.0——Tomcat6.0

```xml
<?xml version="1.0" encoding="UTF-8"?>  
<web-app xmlns="http://java.sun.com/xml/ns/javaee"  
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">  
</web-app>
```

​	**d、**web.xml——version3.0——JDK6.0——Tomcat7.0

```xml
<?xml version="1.0" encoding="UTF-8"?>  
<web-app xmlns="http://java.sun.com/xml/ns/javaee"  
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">
        <display-name>Archetype Created Web Application</display-name>
</web-app>

```

​	**e、**web.xml——version3.1——JDK7.0——Tomcat8.0,Tomcat8.5

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
	<display-name>Archetype Created Web Application</display-name>
</web-app>

```

​	**f、**web.xml——version4.0——JDK8.0——Tomcat9.0

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" version="4.0">
    <display-name>Archetype Created Web Application</display-name>
</web-app>

```



### 3、**<icon>Web应用图标**

```xml
<icon>
    <small-icon>/images/app_small.gif</small-icon>
    <large-icon>/images/app_large.gif</large-icon>
</icon>	
```

这个地方的图标就是标签页的小图标



### 4、<display-name>Web应用名称

```xml
<display-name>Tomcat Example</display-name>
```



### 5、<disciption>Web应用描述

```xml
<disciption>Tomcat Example servlets and JSP pages.</disciption>
```



### 6、<context-param>上下文参数

声明应用范围内的初始化参数。它用于向 ServletContext提供键值对，即应用程序上下文信息。我们的listener, filter等在初始化时会用到这些上下文中的信息。在servlet里面可以通过getServletContext().getInitParameter("context/param")得到。

```xml
<context-param>
	<param-name>ContextParameter</para-name>
	<param-value>test</param-value>
	<description>It is a test parameter.</description>
</context-param>
```


### 7、<filter>过滤器

```xml
<filter>
    <filter-name>setCharacterEncoding</filter-name>
    <filter-class>com.myTest.setCharacterEncodingFilter</filter-class>  //拦截器所在类
    <init-param>
        <param-name>encoding</param-name>   //这个是参数名
        <param-value>UTF-8</param-value>	//这个是参数值
    </init-param>
</filter>
<filter-mapping>
    <filter-name>setCharacterEncoding</filter-name>  
    <url-pattern>/*</url-pattern>  //表示拦截所有的路径
</filter-mapping>

```

注明：这个过滤器就是一个字符编码过滤器

< url-pattern>/</url-pattern>  会匹配到/login这样的路径型url，不会匹配到模式为*.jsp这样的后缀型url

< url-pattern>/*</url-pattern> 会匹配所有url：路径型的和后缀型的url(包括/login,.jsp,.js和.html等)



### 8、<sevlet>

```xml
<servlet>
    <servlet-name>snoop</servlet-name>
    <servlet-class>SnoopServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>snoop</servlet-name>
    <url-pattern>/snoop</url-pattern>
</servlet-mapping>
```

这是我们最关心的地方

即请求SnoopServlet的时候写的路径是localhost://端口/项目名/snoop，这样就可以请求到这个接口



### 9、<session-config>会话超时配置

```xml
<session-config>
    <session-timeout>120</session-timeout>
</session-config>
```

表示的是session保持120分钟



### 10、<welcome-file-list>欢迎文件页

```xml
<welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
</welcome-file-list>
```



### 11、<error-page>错误页面

```xml
<!-- 1、通过错误码来配置error-page。当系统发生×××错误时，跳转到错误处理页面。 -->
<error-page>
    <error-code>404</error-code>
    <location>/NotFound.jsp</location>
</error-page>
<!-- 2、通过异常的类型配置error-page。当系统发生java.lang.NullException（即空指针异常）时，跳转到错误处理页面。 -->
<error-page>
    <exception-type>java.lang.NullException</exception-type>
    <location>/error.jsp</location>
</error-page>
```



### 12、<jsp-config>设置jsp

```xml
<jsp-config>
    <taglib>
        <taglib-uri>Taglib</taglib-uri>
        <taglib-location>/WEB-INF/tlds/MyTaglib.tld</taglib-location>
    </taglib>
    <jsp-property-group>
        <description>Special property group for JSP Configuration JSP example.</description>
        <display-name>JSPConfiguration</display-name>
        <url-pattern>/jsp/* </url-pattern>
        <el-ignored>true</el-ignored>
        <page-encoding>GB2312</page-encoding>
        <scripting-invalid>true</scripting-invalid>
        <include-prelude>/include/prelude.jspf</include-prelude>
        <include-coda>/include/coda.jspf</include-coda>
    </jsp-property-group>
</jsp-config>


<description>：设定的说明 
<display-name>：设定名称 
<url-pattern>：设定值所影响的范围，如： /CH2 或 /*.jsp
<el-ignored>：若为 true，表示不支持 EL 语法 
<scripting-invalid>：若为 true，表示不支持 <% scripting %>语法 
<page-encoding>：设定 JSP 网页的编码 
<include-prelude>：设置 JSP 网页的抬头，扩展名为 .jspf
<include-coda>：设置 JSP 网页的结尾，扩展名为 .jspf
```

**<taglib>字标签用法：**

​	jsp-config

               - taglib(用于申明jsp自定义标签库)

                          - taglib-uri（标签库暴露在外的uri，这个参数是为了避免暴露真实路径而设置的，没有过多含义）

                          - taglib-location（标签库实际的地址）



例子：

1. web.xml中，定义如下：

```xml
<jsp-config>
  	<taglib>
   		<taglib-uri>http://www.aa.com/ebiz</taglib-uri>
   		<taglib-location>/WEB-INF/tld/ebiz.tld</taglib-location>
  	</taglib>
 </jsp-config>

```

2.  在jsp引入如下：

<%@ taglib prefix="ebiz" uri="http://www.aa.com/ebiz"%>

这样，jsp就能根据uri寻找到真实的location，从而找到自定义的jsp标签。

