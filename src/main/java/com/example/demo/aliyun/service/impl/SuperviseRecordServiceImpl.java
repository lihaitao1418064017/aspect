package com.example.demo.aliyun.service.impl;



import com.example.demo.aliyun.dao.SuperviseRecordDao;
import com.example.demo.aliyun.entity.SuperviseRecord;
import com.example.demo.aliyun.service.SuperviseRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* @Description:
* @Author:         Lihaitao
* @Date:       2018/11/12 11:10
*/
@Service("superviseRecordService")
@Slf4j
public class SuperviseRecordServiceImpl implements SuperviseRecordService {

    @Autowired
    private SuperviseRecordDao superviseRecordDao;


    @Override
    public List<SuperviseRecord> selectSuperviseRecord(Long id) {
        return superviseRecordDao.getSuperviseRecords(id);
    }

}
