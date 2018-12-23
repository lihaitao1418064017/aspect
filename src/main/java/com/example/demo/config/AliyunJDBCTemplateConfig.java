package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description JDBCTemplateConfig:
 * @Author LiHaitao
 * @Date 2018/11/14 10:31
 **/
@Configuration
@Import(DataSourceConfig.class)
public class AliyunJDBCTemplateConfig {

    @Resource(name = "aliyun")
    private DataSource dataSource;

    @Bean(name = "aliyunJDBCTemplate")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
