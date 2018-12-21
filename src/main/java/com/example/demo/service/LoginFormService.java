package com.example.demo.service;

import com.example.demo.entity.LoginForm;

public interface LoginFormService {


    LoginForm add(LoginForm loginForm);

    LoginForm findByName(String name);
}


