package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Description:
 * @author: issac
 * @create 2018/11/13 下午7:35
 **/
@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.first")
    @Primary
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }

    @Bean(name = "aliyun")
    @Qualifier("aliyun")
    @ConfigurationProperties(prefix="spring.datasource.druid.second")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }
//
    @Bean(name = "thirdDataSource")
    @Qualifier("thirdDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.third")
    public DataSource thirdDataSource() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }




}
