package com.example.demo.service.serviceImpl;

import com.example.demo.dao.LoginMessageDao;
import com.example.demo.entity.LoginMessage;
import com.example.demo.service.LoginMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description LoginMessageServiceImpl:
 * @Author LiHaitao
 * @Date 2018/12/21 10:10
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Service
public class LoginMessageServiceImpl implements LoginMessageService {
    @Autowired
    private LoginMessageDao loginMessageDao;


//    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public LoginMessage registerMessage(LoginMessage loginMessage) {
        return loginMessageDao.save(loginMessage);
    }

//    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public LoginMessage updateLoginMessage(LoginMessage loginMessage) {
        return loginMessageDao.save(loginMessage);
    }

//    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public LoginMessage findByName(String name) {
        return loginMessageDao.findByUsername(name);
    }


}

