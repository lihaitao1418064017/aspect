package com.example.demo.service.serviceImpl;

import com.example.demo.dao.UserDao;
import com.example.demo.datasources.DataSourceNames;
import com.example.demo.datasources.annotation.DataSource;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description UserServiceImpl:
 * @Author LiHaitao
 * @Date 2018/12/19 14:11
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> selectAll() {
        return userDao.findAll();
    }


    @Override
    public User selectById(Long id) {
        return userDao.findById(id).get();
    }

    @DataSource(name = DataSourceNames.FIRST)
    @Override
    public User add(User user) {
        return userDao.save(user);
    }


    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
