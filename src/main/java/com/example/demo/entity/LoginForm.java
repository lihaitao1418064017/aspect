package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description LoginForm:
 * @Author LiHaitao
 * @Date 2018/12/21 13:43
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Entity
@Data
@Table(name = "login_form")
public class LoginForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;
}
