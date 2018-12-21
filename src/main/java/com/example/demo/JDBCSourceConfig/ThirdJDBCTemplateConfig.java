package com.example.demo.JDBCSourceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
* @Description:
* @Author:         LiHaitao
* @CreateDate:     2018/12/21 16:26
* @UpdateUser:
* @UpdateDate:
* @UpdateRemark:
* @Version:        1.0.0
*/
@Configuration
@Import(DataSourceConfig.class)
public class ThirdJDBCTemplateConfig {

    @Resource(name = "thirdDataSource")
    private DataSource dataSource;

    @Bean(name = "thirdSourceJDBCTemplate")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
