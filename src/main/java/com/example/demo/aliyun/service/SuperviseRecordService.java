package com.example.demo.aliyun.service;




import com.example.demo.aliyun.entity.SuperviseRecord;

import java.util.List;

/**
* @Description:
* @Author:         Lihaitao
* @Date:       2018/11/12 11:08
*/
public interface SuperviseRecordService{


    /**
     * 根据条件查询
     */
    List<SuperviseRecord> selectSuperviseRecord(Long id);
}
