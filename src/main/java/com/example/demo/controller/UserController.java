package com.example.demo.controller;

import com.example.demo.annotation.LogAnnotation;
import com.example.demo.datasources.DataSourceNames;
import com.example.demo.datasources.annotation.DataSource;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description UserController:
 * @Author LiHaitao
 * @Date 2018/12/19 14:14
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @LogAnnotation("查询所有用户")
    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.selectAll();
    }


    @LogAnnotation("FindUserById")
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id){
        return userService.selectById(id);
    }
}
