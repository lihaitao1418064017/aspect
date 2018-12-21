package com.example.demo.dao;

import com.example.demo.entity.LoginMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description LoginMessageDao:
 * @Author LiHaitao
 * @Date 2018/12/21 10:09
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
public interface LoginMessageDao extends JpaRepository<LoginMessage,Long> {


    LoginMessage findByUsername(String username);
}
