## Spring bean管理

```xml
<bean id="beanProvider" class="org.common.BeanProvider"/>
 
<bean id="userService" class="org.enson.service.UserService"/>
```



### 1、单例模式

Springbean在默认情况下是单例模式。

#### **什么是单例模式？**

​    在整个项目周期内只有一个对象实例存在

#### **五种单例模式实现方式**

​	**第一种：饿汉式   直接加载，效率高，线程安全（如果有内存问题，不推荐使用这种）**

```java
public class SingletonDemo1{ 
     private static SingletonDemo1 instance = new SingletonDemo1; 
     private SingletonDemo1(){} 
     public static SingletonDemo1 getInstance(){  
          return SingletonDemo1;  
      } 
}
```

​	第二种：懒汉式  第一种 使用锁的形式来完成懒加载，线程是不安全，但是效率很低，一般不推荐使用

```java
public class SingletonDemo2 {
     
    //类初始化时，不初始化这个对象(延时加载，真正用的时候再创建)
    private static SingletonDemo2 instance;
     
    //构造器私有化
    private SingletonDemo2(){}
     
    //方法同步，调用效率低
    public static synchronized SingletonDemo2 getInstance(){
        if(instance==null){
            instance=new SingletonDemo2();
        }
        return instance;
    }
}
```

对于懒汉式的线程不安全解释：如果存在高并发的时候，在new的过程中，又执行了if判断，就会存在出现多个对象实例，就达不到单例模式的特点，一般不使用

​	**第三种：懒汉式  第二种 双重锁机制** 

```java
public class SingletonDemo3 {
        private volatile static SingletonDemo3 SingletonDemo3;
 
        private SingletonDemo3() {
        }
 
        public static SingletonDemo3 newInstance() {
            if (SingletonDemo3 == null) {
                synchronized (SingletonDemo3.class) {
                    if (SingletonDemo3 == null) {
                        SingletonDemo3 = new SingletonDemo3();
                    }
                }
            }
            return SingletonDemo3;
        }
    }
```

​	在第一种懒汉式的基础上改造而出，能够保证线程安全

 	**第四种：静态内部类单例（属于懒汉式**）

```java
public class SingletonDemo4 {
     
    private static class SingletonClassInstance{
        private static final SingletonDemo4 instance=new SingletonDemo4();
    }
     
    private SingletonDemo4(){}
     
    public static SingletonDemo4 getInstance(){
        return SingletonClassInstance.instance;
    }
     
}
```

​	依靠的是jdk机制，静态内部类不会随着外部类 的加载而加载，只会在使用到时才会加载，并且在加载过程中是线程安全，所以在实际开发当中是推荐使用的

 	**第五种： 枚举型单例 （属于饿汉式 ）**

```java
public enum SingletonDemo5 {
     
    //枚举元素本身就是单例
    INSTANCE;
     
    //添加自己需要的操作
    public void singletonOperation(){     
    }
}
```

​	线程安全，调用效率高，不能延时加载，可以天然的防止反射和反序列化调用



**Spring框架对单例的实现**  

```java
public abstract class AbstractBeanFactory implements ConfigurableBeanFactory{  
   /** 
    * 充当了Bean实例的缓存，实现方式和单例注册表相同 
    */  
   private final Map singletonCache=new HashMap();  
   public Object getBean(String name)throws BeansException{  
       return getBean(name,null,null);  
   }  
...  
   public Object getBean(String name,Class requiredType,Object[] args)throws BeansException{  
      //对传入的Bean name稍做处理，防止传入的Bean name名有非法字符(或则做转码)  
      String beanName=transformedBeanName(name);  
      Object bean=null;  
      //手工检测单例注册表  
      Object sharedInstance=null;  
      //使用了代码锁定同步块，原理和同步方法相似，但是这种写法效率更高  
      synchronized(this.singletonCache){  
         sharedInstance=this.singletonCache.get(beanName);  
       }  
      if(sharedInstance!=null){  
         ...  
         //返回合适的缓存Bean实例  
         bean=getObjectForSharedInstance(name,sharedInstance);  
      }else{  
        ...  
        //取得Bean的定义  
        RootBeanDefinition mergedBeanDefinition=getMergedBeanDefinition(beanName,false);  
         ...  
        //根据Bean定义判断，此判断依据通常来自于组件配置文件的单例属性开关  
        //`<bean id="date" class="java.util.Date" scope="singleton"/>`  
        //如果是单例，做如下处理  
        if(mergedBeanDefinition.isSingleton()){  
           synchronized(this.singletonCache){  
            //再次检测单例注册表  
             sharedInstance=this.singletonCache.get(beanName);  
             if(sharedInstance==null){  
                ...  
               try {  
                  //真正创建Bean实例  
                  sharedInstance=createBean(beanName,mergedBeanDefinition,args);  
                  //向单例注册表注册Bean实例  
                   addSingleton(beanName,sharedInstance);  
               }catch (Exception ex) {  
                  ...  
               }finally{  
                  ...  
              }  
             }  
           }  
          bean=getObjectForSharedInstance(name,sharedInstance);  
        }  
       //如果是非单例，即prototpye，每次都要新创建一个Bean实例  
       //<bean id="date" class="java.util.Date" scope="prototype"/>  
       else{  
          bean=createBean(beanName,mergedBeanDefinition,args);  
       }  
}  
...  
   return bean;  
}  
}   

```

既不是饿汉式也不是懒汉式，而是通过注册表的形式来进行管理。