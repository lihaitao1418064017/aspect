package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description User:
 * @Author LiHaitao
 * @Date 2018/12/19 14:03
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String profession;


}
