package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description UserDao:
 * @Author LiHaitao
 * @Date 2018/12/19 14:07
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
public interface UserDao extends JpaRepository<User,Long> {

    User findByName(String name);
}
