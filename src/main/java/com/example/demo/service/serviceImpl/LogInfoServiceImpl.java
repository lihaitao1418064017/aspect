package com.example.demo.service.serviceImpl;

import com.example.demo.dao.LogInfoDao;
import com.example.demo.datasources.DataSourceNames;
import com.example.demo.datasources.annotation.DataSource;
import com.example.demo.entity.LogInfo;
import com.example.demo.service.LogInfoService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description LogInfoServiceImpl:
 * @Author LiHaitao
 * @Date 2018/12/20 10:15
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Service
public class  LogInfoServiceImpl implements LogInfoService {
    @Autowired
    private LogInfoDao logInfoDao;
    @Override
    public List<LogInfo> selectAll() {
      return   logInfoDao.findAll();
    }

    @Override
    public LogInfo selectById(Long id) {
        return logInfoDao.findById(id).get();
    }


    @Override
    public Long insert(LogInfo logInfo) {
        LogInfo save = logInfoDao.save(logInfo);
        return save.getId();
    }
}
