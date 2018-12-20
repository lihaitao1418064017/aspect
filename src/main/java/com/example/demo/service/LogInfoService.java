package com.example.demo.service;

import com.example.demo.entity.LogInfo;

import java.util.List;

/**
 * @Description LogInfoService:
 * @Author LiHaitao
 * @Date 2018/12/20 10:13
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
public interface LogInfoService  {

    List<LogInfo> selectAll();

    LogInfo selectById(Long id);

    Long insert(LogInfo logInfo);
}
