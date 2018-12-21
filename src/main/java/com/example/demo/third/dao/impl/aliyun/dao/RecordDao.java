package com.example.demo.third.dao.impl.aliyun.dao;


import com.example.demo.third.dao.impl.aliyun.entity.Record;

import java.util.List;

/**
* @Description:
* @Author:         Lihaitao
* @Date:       2018/11/12 11:07
*/

public interface RecordDao {



   List<Record> getSuperviseRecords(Long id);


}
