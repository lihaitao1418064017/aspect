package com.example.demo.controller;

import com.example.demo.annotation.LogAnnotation;
import com.example.demo.annotation.LoginMsg;
import com.example.demo.datasources.DataSourceNames;
import com.example.demo.datasources.annotation.DataSource;
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

    @Autowired
    private LoginFormService loginFormService;


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


    @PostMapping("/register")
    public boolean register(@RequestBody User user){
        User user1= userService.add(user);
        LoginForm loginForm=new LoginForm();
        loginForm.setName(user.getName());
        loginForm.setPassword(user.getPassword());
        LoginForm loginForm1=loginFormService.add(loginForm);
        if (user1!=null&&loginForm1!=null) {
            return true;
        }
        return false;
    }

}
