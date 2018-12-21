package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @Description LoginMsg:
 * @Author LiHaitao
 * @Date 2018/12/21 10:49
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginMsg {
    String value() default "";
}
