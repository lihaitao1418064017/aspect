package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description LoginMessage:登录消息
 * @Author LiHaitao
 * @Date 2018/12/21 10:02
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Data
@Entity
@Table(name = "login_message")
public class LoginMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ip
     */
    private String ip;

    /**
     * user
     */
    private String username;

    /**
     * login time
     */
    private Date loginTime;

    /**
     * password
     */
    private String password;

}
