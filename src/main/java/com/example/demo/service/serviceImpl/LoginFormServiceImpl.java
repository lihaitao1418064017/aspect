package com.example.demo.service.serviceImpl;

import com.example.demo.dao.LoginFormDao;
import com.example.demo.datasources.DataSourceNames;
import com.example.demo.datasources.annotation.DataSource;
import com.example.demo.entity.LoginForm;
import com.example.demo.service.LoginFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description LoginFormServiceImpl:
 * @Author LiHaitao
 * @Date 2018/12/21 13:47
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Service
public class LoginFormServiceImpl implements LoginFormService {
    @Autowired
    private LoginFormDao loginFormDao;

    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public LoginForm add(LoginForm loginForm) {
        return loginFormDao.save(loginForm);
    }

    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public LoginForm findByName(String name) {
        return loginFormDao.findByName(name);
    }
}
