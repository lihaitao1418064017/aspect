package com.example.demo.service;

import com.example.demo.entity.LoginMessage;

public interface LoginMessageService {

    LoginMessage registerMessage(LoginMessage loginMessage);

    LoginMessage updateLoginMessage(LoginMessage loginMessage);

    LoginMessage findByName(String name);
}
