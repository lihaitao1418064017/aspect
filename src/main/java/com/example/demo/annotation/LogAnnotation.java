package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @Description LogAnnotation:
 * @Author LiHaitao
 * @Date 2018/12/19 10:03
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String value() default "";
}


