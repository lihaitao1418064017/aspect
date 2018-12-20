package com.example.demo.annoation_demo;

import java.lang.reflect.Field;

/**
 * @Description AnnotionImple:
 * @Author LiHaitao
 * @Date 2018/12/19 10:15
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
public class AnnotionImple {

    public static Apple createApple(Class c){
        Apple apple=new Apple();
        Field[] fields=c.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field:fields){
                     if(field.isAnnotationPresent(FruitName.class)){
                              FruitName name = field.getAnnotation(FruitName.class);
                              apple.setName(name.name());
                          }
                      if(field.isAnnotationPresent(FruitColor.class)){
                              FruitColor color = field.getAnnotation(FruitColor.class);
                              apple.setColor(color.fruitColor().name());
                          }
                      if(field.isAnnotationPresent(FruitProvider.class)){
                              FruitProvider Provider = field.getAnnotation(FruitProvider.class);
                              Provider provider=new Provider();
                              provider.setAddress(Provider.address());
                              provider.setId(Provider.id());
                              provider.setUser(Provider.user());
                              apple.setProvider(provider);
                          }
        }
        return apple;
    }
}
