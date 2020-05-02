import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class UseAnnotationDemo3 {
}

//第一步，用@interface定义注解：
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Report2 {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

//第二步，添加参数、默认值：
//第三步，用元注解配置注解：
//其中，必须设置@Target和@Retention，@Retention一般设置为RUNTIME，
//因为我们自定义的注解通常要求在运行期读取。
//一般情况下，不必写@Inherited和@Repeatable。