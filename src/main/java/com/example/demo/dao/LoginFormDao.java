package com.example.demo.dao;

import com.example.demo.entity.LoginForm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description LoginFormDao:
 * @Author LiHaitao
 * @Date 2018/12/21 13:44
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
public interface LoginFormDao extends JpaRepository<LoginForm,Long> {
    LoginForm findByName(String name);
}
