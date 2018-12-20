package com.example.demo.annoation_demo;

/**
 * @Description Main:
 * @Author LiHaitao
 * @Date 2018/12/19 10:08
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
public class Main {
    public static void main(String[] args) {
        Apple apple=AnnotionImple.createApple(Apple.class);
        System.out.println(apple.toString());
    }
}
