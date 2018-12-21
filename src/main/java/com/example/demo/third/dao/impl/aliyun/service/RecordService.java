package com.example.demo.third.dao.impl.aliyun.service;




import com.example.demo.third.dao.impl.aliyun.entity.Record;

import java.util.List;

/**
* @Description:
* @Author:         Lihaitao
* @Date:       2018/11/12 11:08
*/
public interface RecordService {


    /**
     * 根据条件查询
     */
    List<Record> selectSuperviseRecord(Long id);
}
