package com.example.demo.dao;

import com.example.demo.entity.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description LogInfoDao:
 * @Author LiHaitao
 * @Date 2018/12/20 10:15
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/

public interface LogInfoDao extends JpaRepository<LogInfo,Long> {
}
