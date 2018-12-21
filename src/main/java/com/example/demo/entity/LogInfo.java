package com.example.demo.entity;

//import com.example.demo.datasources.DataSourceNames;
//import com.example.demo.datasources.annotation.DataSource;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description LogInfo:
 * @Author LiHaitao
 * @Date 2018/12/20 10:11
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Data
@Entity
@Table(name = "log_info")
public class LogInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 访问方法
     */
    private String method;
    /**
     * 方法参数
     */
    private String params;

    private String operation;



}
