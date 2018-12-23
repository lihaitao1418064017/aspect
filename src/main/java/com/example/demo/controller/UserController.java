package com.example.demo.controller;

import com.example.demo.annotation.LogAnnotation;
import com.example.demo.annotation.LoginMsg;
import com.example.demo.annotation.RequestAnnotation;
import com.example.demo.entity.LoginForm;
import com.example.demo.entity.LoginMessage;
import com.example.demo.entity.User;
import com.example.demo.service.LoginFormService;
import com.example.demo.service.LoginMessageService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserService userService;



    @RequestAnnotation("user模块请求")
    @LogAnnotation("查询所有用户")
    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.selectAll();
    }

    @RequestAnnotation("user模块请求")
    @LogAnnotation("通过id查找用户")
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id){
        return userService.selectById(id);
    }

    @RequestAnnotation("user模块请求")
    @PostMapping("/register")
    @LogAnnotation("注冊用戶")
    public User register(@RequestBody User user){
        return userService.add(user);
    }

}
