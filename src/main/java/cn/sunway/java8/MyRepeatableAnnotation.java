package cn.sunway.java8;

import java.lang.annotation.*;

/**
 * @author sunw
 * @date 2023/2/27
 */
@Repeatable(MyRepeatableAnnotations.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatableAnnotation {
    String value() default "";
}
