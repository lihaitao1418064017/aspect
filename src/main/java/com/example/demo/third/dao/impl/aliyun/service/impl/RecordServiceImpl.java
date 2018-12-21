package com.example.demo.third.dao.impl.aliyun.service.impl;



import com.example.demo.third.dao.impl.aliyun.dao.RecordDao;
import com.example.demo.third.dao.impl.aliyun.entity.Record;
import com.example.demo.third.dao.impl.aliyun.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* @Description:
* @Author:         Lihaitao
* @Date:       2018/11/12 11:10
*/
@Service("recordService")
@Slf4j
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao superviseRecordDao;


    @Override
    public List<Record> selectSuperviseRecord(Long id) {
        return superviseRecordDao.getSuperviseRecords(id);
    }

}
