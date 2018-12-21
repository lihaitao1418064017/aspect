package com.example.demo.third.dao.impl.aliyun.dao.impl;


import com.example.demo.third.dao.impl.aliyun.dao.RecordDao;
import com.example.demo.third.dao.impl.aliyun.entity.Record;
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
public class RecordDaoImpl implements RecordDao {

    @Autowired
    @Qualifier("thirdSourceJDBCTemplate")
    private JdbcTemplate sqlServerJdbcTemplate;



    public List<Record> getSuperviseRecords(Long id) {
        if (null==id){
            log.info("id为空，name：{}",id);
            return null;
        }
        String sql = "SELECT * FROM record WHERE id=?";
        List<Record> superviseRecordList = sqlServerJdbcTemplate.query(sql, new SuperviseRecordMapper(), id);
        if (superviseRecordList==null){
            log.error("getSuperviseRecords查询失败");
        }
        return superviseRecordList;
    }

    class SuperviseRecordMapper implements RowMapper<Record> {
        @Override
        public Record mapRow(ResultSet resultSet, int i) throws SQLException {
            Record superviseRecord=new Record();
            superviseRecord.setCreateCode(resultSet.getString("create_code"));
            superviseRecord.setCreateName(resultSet.getString("create_name"));
            superviseRecord.setId(resultSet.getLong("id"));
            return superviseRecord;
        }
    }


}
