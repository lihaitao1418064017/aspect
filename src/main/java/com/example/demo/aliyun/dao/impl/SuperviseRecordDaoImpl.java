package com.example.demo.aliyun.dao.impl;


import com.example.demo.aliyun.dao.SuperviseRecordDao;
import com.example.demo.aliyun.entity.SuperviseRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
* @Description:
* @Author:         Lihaitao
* @Date:       2018/11/12 11:07
*/
@Repository
@Slf4j
public class SuperviseRecordDaoImpl implements SuperviseRecordDao {

    @Autowired
    @Qualifier("aliyunJDBCTemplate")
    private JdbcTemplate sqlServerJdbcTemplate;



    public List<SuperviseRecord> getSuperviseRecords(Long id) {
        if (null==id){
            log.info("id为空，name：{}",id);
            return null;
        }
        String sql = "SELECT * FROM suprivise WHERE id=?";
        List<SuperviseRecord> superviseRecordList = sqlServerJdbcTemplate.query(sql, new SuperviseRecordMapper(), id);
        if (superviseRecordList==null){
            log.error("getSuperviseRecords查询失败");
        }
        return superviseRecordList;
    }

    class SuperviseRecordMapper implements RowMapper<SuperviseRecord> {
        @Override
        public SuperviseRecord mapRow(ResultSet resultSet, int i) throws SQLException {
            SuperviseRecord superviseRecord=new SuperviseRecord();
            superviseRecord.setCreateCode(resultSet.getString("create_code"));
            superviseRecord.setCreateName(resultSet.getString("create_name"));
            superviseRecord.setId(resultSet.getLong("id"));
            return superviseRecord;
        }
    }


}
