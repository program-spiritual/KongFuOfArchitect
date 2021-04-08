import java.lang.annotation.*;

public class UseAnnotationDemo2 {}

//Java语言使用@interface语法来定义注解（Annotation），它的格式如下：
//例如，定义注解@Report可用在方法上，我们必须添加一个@Target(ElementType.METHOD)：
//定义注解@Report可用在方法或字段上，可以把@Target注解参数变为数组{ ElementType.METHOD, ElementType.FIELD }：
//@Target(ElementType.METHOD)
//使用@Repeatable这个元注解可以定义Annotation是否可重复。这个注解应用不是特别广泛。
@Target({ ElementType.METHOD, ElementType.FIELD })
//实际上@Target定义的value是ElementType[]数组，只有一个元素时，可以省略数组的写法。
@Inherited
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(Reports.class)
@interface Report {
  int type() default 0;

  String level() default "info";

  String value() default "";
}

@Target(ElementType.TYPE)
@interface Reports {
  Report[] value();
}
//注解的参数类似无参方法，可以用default设定一个默认值（强烈推荐）。最常用的参数应当命名为value。
//最常用的元注解是@Target。使用@Target可以定义Annotation能够被应用于源码的哪些位置
/**
 * 类或接口：ElementType.TYPE；
 * 字段：ElementType.FIELD；
 * 方法：ElementType.METHOD；
 * 构造方法：ElementType.CONSTRUCTOR；
 * 方法参数：ElementType.PARAMETER。
 * */
//另一个重要的元注解@Retention定义了Annotation的生命周期：
/**
 * 仅编译期：RetentionPolicy.SOURCE；
 * 仅class文件：RetentionPolicy.CLASS；
 * 运行期：RetentionPolicy.RUNTIME。
 * */
//如果@Retention不存在，则该Annotation默认为CLASS。
//        因为通常我们自定义的Annotation都是RUNTIME，所以，务必要加上@Retention(RetentionPolicy.RUNTIME)这个元注解：
//@Target(ElementType.TYPE)
//使用@Inherited定义子类是否可继承父类定义的Annotation。@Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，并且仅针对class的继承，对interface的继承无效：
