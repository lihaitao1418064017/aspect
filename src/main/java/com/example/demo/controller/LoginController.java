package com.example.demo.controller;

import com.example.demo.annotation.LoginMsg;
import com.example.demo.entity.LoginForm;
import com.example.demo.service.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description LoginController:
 * @Author LiHaitao
 * @Date 2018/12/21 13:48
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/form")
public class LoginController {

    @Autowired
    private LoginFormService loginFormService;

    @RequestMapping("/login")
    @LoginMsg("登录")
    public LoginForm loginForm(String username,String password){
        LoginForm loginForm=loginFormService.findByName(username);
        if (loginForm.getPassword().equals(password)){
            return loginForm;
        }
        return null;
    }
}
