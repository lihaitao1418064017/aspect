package com.example.demo.aliyun.controller;

import com.example.demo.aliyun.entity.SuperviseRecord;
import com.example.demo.aliyun.service.SuperviseRecordService;
import com.example.demo.third.dao.impl.aliyun.entity.Record;
import com.example.demo.third.dao.impl.aliyun.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description RecordController:
 * @Author LiHaitao
 * @Date 2018/12/21 17:08
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/supervise")
public class SuperviseRecordController {

    @Autowired
    private SuperviseRecordService superviseRecordService;

    @GetMapping("/list/{id}")
    public List<SuperviseRecord> list(@PathVariable Long id){
        return superviseRecordService.selectSuperviseRecord(id);
    }
}
