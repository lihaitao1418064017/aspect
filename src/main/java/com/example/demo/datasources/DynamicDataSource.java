//package com.example.demo.datasources;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
///**
//* @Description:
//* @Author:         LiHaitao
//* @CreateDate:     2018/12/20 13:48
//* @UpdateUser:
//* @UpdateDate:
//* @UpdateRemark:
//* @Version:        1.0.0
//*/
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
//
//    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
//        super.setDefaultTargetDataSource(defaultTargetDataSource);
//        super.setTargetDataSources(targetDataSources);
//        super.afterPropertiesSet();
//    }
//
//    /**
//     * 根据key获取对应数据源
//     * @return
//     */
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return getDataSource();
//    }
//
//    public static void setDataSource(String dataSource) {
//        contextHolder.set(dataSource);
//    }
//
//    public static String getDataSource() {
//        return contextHolder.get();
//    }
//
//    public static void clearDataSource() {
//        contextHolder.remove();
//    }
//
//}
