package top.ningg.spring.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by guoning on 15/9/20.
 */

// 注解的保留时间: 运行时
@Retention(value = RetentionPolicy.RUNTIME)
// 使用注解的目标类型: 方法
@Target(value = ElementType.METHOD)
// 定义注解
public @interface NeedTest {

    // 定义属性
    boolean value() default true;
}
