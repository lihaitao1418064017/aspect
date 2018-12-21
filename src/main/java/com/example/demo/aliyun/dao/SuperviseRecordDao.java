package com.example.demo.aliyun.dao;


import com.example.demo.aliyun.entity.SuperviseRecord;

import java.util.List;

/**
* @Description:
* @Author:         Lihaitao
* @Date:       2018/11/12 11:07
*/

public interface SuperviseRecordDao {



   List<SuperviseRecord> getSuperviseRecords(Long id);


}
