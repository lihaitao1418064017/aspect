package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> selectAll();

    User selectById(Long id);

    User add(User user);

    User findByName(String name);

}
