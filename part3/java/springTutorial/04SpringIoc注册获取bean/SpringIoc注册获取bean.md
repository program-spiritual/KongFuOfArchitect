通用bean

```java
public class Person {
    private String name;
    private Integer age;

    public Person(){
        super();
    }

    public Person(String name,Integer age){
        super();
        this.name=name;
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
```



### 一、xml配置方式

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="user" class="com.enjoy.cap1.Person">
        <property name="name" value="zhangsan"/>
        <property name="age" value="23"/>
    </bean>
</beans>
```

获取bean

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainTest1 {
    public static void main(String []args){
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        Person person= (Person) ac.getBean("user");
        System.out.println(person);
    }
}
```

### 二、使用注解的方式

**第一种形式**

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MainConfig {
    @Bean
    public Person person(){
        return new Person("lisi",20);
    }
}
```

注意：这里的@Configuration一定不能忘记，它就可以当做标记这个类是一个配置文件

```java
public class MainTest2 {
    public static void main(String []args){
        ApplicationContext app=new AnnotationConfigApplicationContext(MainConfig.class);
        Person person= (Person) app.getBean("person"); //person就是获取bean的方法名，方法名可以随意改，一般就是bean的类名
        System.out.println(person);
    }
}
```

**第二种形式**

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MainConfig {
    @Bean（"user"）
    public Person person(){
        return new Person("lisi",20);
    }
}
```

```java
public class MainTest2 {
    public static void main(String []args){
        ApplicationContext app=new AnnotationConfigApplicationContext(MainConfig.class);
        Person person= (Person) app.getBean("user"); 
        System.out.println(person);
    }
}
```



### 三、懒加载

####       1.xml配置

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="user" class="com.enjoy.cap1.Person" lazy-init="true">
        <property name="name" value="zhangsan"/>
        <property name="age" value="23"/>
    </bean>
</beans>
```

####     2.注解配置

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MainConfig {
    @Lazy
    @Bean
    public Person person(){
        return new Person("lisi",20);
    }
}
```

​	