package zhujie;

import java.lang.annotation.*;

//写一个与Test注解相同作用的注解
@Retention(RetentionPolicy.RUNTIME) //使用元注解，使得自定义注解的作用范围扩大
@Target(ElementType.ANNOTATION_TYPE.METHOD)
public @interface MyTest {

long Timeout() default -1;
}
