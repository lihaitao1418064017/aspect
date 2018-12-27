package com.example.demo;

//import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryAction;
import org.elasticsearch.index.reindex.UpdateByQueryRequestBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @author: issac
 * @create 2018/5/9 下午7:25
 **/
public class Es {

    Client client;

//    @Before
//    public void prepate() throws UnknownHostException {
//        Settings settings = Settings.builder().put("cluster.name", "es-prod").build();
//        client = new PreBuiltTransportClient(settings)
////                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.65.3.5"), 19300));
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.255.228.103"), 9200));
//    }
//
//    @Before
//    public void prepateProd() throws UnknownHostException {
//        Settings settings = Settings.builder().put("cluster.name", "es-test").build();
//        client = new PreBuiltTransportClient(settings)
////                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.65.0.65"), 19300));
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.255.228.103"), 9300));
//    }


//    @Test
//    public void testInsert() {
//        JSONObject data = new JSONObject();
//        data.put("id", 1);
//        data.put("name", "tom");
//        data.put("age", 33);
//        client.prepareIndex("testupsert", "data").setId("id").setSource(data).execute().actionGet();
//
//
//    }


    @Test
    public void testUpdate() {
        GetResponse result = client.prepareGet("cvf_device", "cvf_device", "cvf_device")
                .execute().actionGet();
        System.out.println("response.getId():"+result.getId());
        System.out.println("response.getSourceAsString():"+result.getSourceAsString());



//        JSONObject data = new JSONObject();
//
//        data.put("name", "jerry");
//        UpdateRequestBuilder requestBuilder = client.prepareUpdate().setIndex("cvf_device").setType("cvf_device").setId("")
//                .setUpsert(data).setDoc(data);
//        UpdateResponse response = requestBuilder.execute().actionGet();
    }


//    @Test
//    public void testUpsert() {
//        String body = "{\"id\":10000,\"name\": \"tom\",\"age\": 10003}";
//        JSONObject data = JSONObject.parseObject(body);
//
//        String index = "testupsert";
//        String indexIdField = "name";
//        String indexType = "data";
//        String value = data.getString(indexIdField);
//
//        SearchRequestBuilder requestBuilder = client.prepareSearch(index)
//                .setTypes(indexType)
//                .setQuery(QueryBuilders.termQuery(indexIdField, value));
//
//        SearchHit[] searchResponse = requestBuilder.get().getHits().getHits();
//        if (searchResponse.length > 0) {
//            String id = searchResponse[0].getId();
//            UpdateRequestBuilder updateRequestBuilder = client.prepareUpdate(index, indexType, id)
//                    .setDoc(data);
//
//            updateRequestBuilder.execute();
//        }
//    }
//
//    @Test
//    public void testUpsert2() {
//        String body = "{\"id\":1,\"name\": \"tom\",\"age\": 13}";
//        JSONObject data = JSONObject.parseObject(body);
//
//        String field = "name";
//        String value = data.getString(field);
//        UpdateByQueryRequestBuilder update = UpdateByQueryAction.INSTANCE.newRequestBuilder(client);
//        update.source("testupsert")
//                .filter(QueryBuilders.termQuery(field, value))
//                .size(1)
//                .script(new Script(ScriptType.INLINE, "painless", "ctx._source = params", data));
//
//        String body2 = "{\"id\":10,\"name\": \"jerry\",\"age\": 103}";
//        JSONObject data2 = JSONObject.parseObject(body2);
//        update.source("testupsert")
//                .filter(QueryBuilders.termQuery("name", "jerry"))
//                .size(1)
//                .script(new Script(ScriptType.INLINE, "painless", "ctx._source = params", data2));
//
//        BulkByScrollResponse response = update.get();
//        System.out.println(response);
//    }
//
////    @Test
////    public void recorderCheck() throws UnsupportedEncodingException {
////        String data = "st=2018-12-12 11:32:45|^|ip=10.255.252.149, 172.20.12.6|^|status=200|^|user=-|^|request=POST /log/cvf/ht_recorder HTTP/1.1|^|reqbody=%7B%22infos%22%3A%7B%22monitorPlatformStatus%22%3A0,%22ictPlatformStatus%22%3A0,%22batteryLevel%22%3A66,%22flowUsageToday%22%3A0,%22flowUsageMonth%22%3A0,%22availableSd%22%3A22600,%22totalSd%22%3A25587,%22cpuRate%22%3A0,%22ramRate%22%3A0,%22totalRam%22%3A0,%22infraredStatus%22%3A0,%22keyMarkStatus%22%3A0,%22videoRecordStatus%22%3A0,%22soundRecordStatus%22%3A0,%22wlanHotspot%22%3A%22KedacomNet%22,%22wifiStatus%22%3A0,%22wifiProbeStatus%22%3A0,%22apnStatus%22%3A0,%22temperature%22%3A33,%22height%22%3A103,%22lon%22%3A120.515990,%22lat%22%3A31.294398,%22speed%22%3A0,%22direction%22%3A103%7D,%22personCode%22%3A%22KD012094%22,%22deptCode%22%3A%22060V%22,%22recorderCode%22%3A%22MP6J106D7400311%22%7D|^|referer=-|^|ua=libghttp/1.0|^|byte=5|^|server_name=localhost|^|host=10.65.0.2|^|hostname=nginx-log-ngwss|^|server_protocol=HTTP/1.1|^|request_method=POST|^|request_uri=/log/cvf/ht_recorder|^|bytes_sent=170|^|content_type=application/json";
////
////
////        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
////        Event event = new SimpleEvent();
////        event.setBody(data.getBytes());
////
////        JSONArray array = new RecorderHeartBeatSerilizar().getMultipleContentBuilder(event);
////
////        for (int i = 0; i < 10; i++) {
////            String index = "cvf_device";
////            String indexType = "cvf_device";
////            String value = "MP6J106D7400311";
////
////            SearchRequestBuilder requestBuilder = client.prepareSearch(index)
////                    .setTypes(indexType)
////                    .setQuery(QueryBuilders.termQuery("code", value));
////
////            SearchHit[] searchResponse = requestBuilder.get().getHits().getHits();
////            if (searchResponse.length > 0) {
////                String id = searchResponse[0].getId();
////                UpdateRequestBuilder updateRequestBuilder = client.prepareUpdate(index, indexType, id)
////                        .setDoc(array.getJSONObject(i));
////                bulkRequestBuilder.add(updateRequestBuilder);
////            }
////        }
////        bulkRequestBuilder.execute();
////    }
//
////    @Test
////    public void stationCheck() throws UnsupportedEncodingException {
//////        String log = "st=2018-12-15 19:45:04|^|ip=172.23.118.125, 172.20.99.4|^|status=200|^|user=-|^|request=POST /log/cvf/ht_station HTTP/1.1|^|reqbody=%7B%0A%20%20%20%20%22stationCode%22%3A%20%22ZCS-KDCA20171GA19P4%22,%0A%20%20%20%20%22availableSd%22%3A%20%222249503543296%22,%0A%20%20%20%20%22totalSd%22%3A%20%224000650883072%22,%0A%20%20%20%20%22appVer%22%3A%20%22ZCS-KDCA2-BZ-1.5.1%22,%0A%20%20%20%20%22softVer%22%3A%20%22ZCS-KDCA2-BZ-1.5.1%22,%0A%20%20%20%20%22devices%22%3A%20%5B%0A%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%22index%22%3A%20%22A04%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22code%22%3A%20%22MP6HB27D3155138%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22syncStatus%22%3A%20%222%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22batteryCapcity%22%3A%20%22100%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22availableSd%22%3A%20%2225497%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22totalSd%22%3A%20%2225600%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22version%22%3A%20%227.45%22%0A%20%20%20%20%20%20%20%20%7D,%0A%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%22index%22%3A%20%22A05%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22code%22%3A%20%22MP6HB27D3156294%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22syncStatus%22%3A%20%222%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22batteryCapcity%22%3A%20%22100%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22availableSd%22%3A%20%220%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22totalSd%22%3A%20%220%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22version%22%3A%20%227.45%22%0A%20%20%20%20%20%20%20%20%7D,%0A%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%22index%22%3A%20%22A03%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22code%22%3A%20%22MP6HB27D3156634%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22syncStatus%22%3A%20%221%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22batteryCapcity%22%3A%20%22100%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22availableSd%22%3A%20%220%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22totalSd%22%3A%20%220%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22version%22%3A%20%227.45%22%0A%20%20%20%20%20%20%20%20%7D,%0A%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%22index%22%3A%20%22A02%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22code%22%3A%20%22MP6HB27D3156965%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22syncStatus%22%3A%20%221%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22batteryCapcity%22%3A%20%22100%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22availableSd%22%3A%20%2225600%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22totalSd%22%3A%20%2225600%22,%0A%20%20%20%20%20%20%20%20%20%20%20%20%22version%22%3A%20%227.38%22%0A%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%5D%0A%7D%0A|^|referer=-|^|ua=cpprestsdk/2.7.0|^|byte=5|^|server_name=localhost|^|host=172.23.123.107|^|hostname=nginx-log-9vwmz|^|server_protocol=HTTP/1.1|^|request_method=POST|^|request_uri=/log/cvf/ht_station|^|bytes_sent=170|^|content_type=application/json; charset=utf-8";
////        String log = "st=2018-12-15 18:06:57|^|ip=172.23.123.107, 172.20.99.4|^|status=200|^|user=-|^|request=POST /log/cvf/ht_station HTTP/1.1|^|reqbody=%7B%22phone%22%3A%2213521389587%22,%22password%22%3A%22test%22%7D|^|referer=-|^|ua=curl/7.29.0|^|byte=5|^|server_name=localhost|^|host=172.23.123.107|^|hostname=nginx-log-9vwmz|^|server_protocol=HTTP/1.1|^|request_method=POST|^|request_uri=/log/cvf/ht_station|^|bytes_sent=170|^|content_type=application/x-www-form-urlencoded";
////        Event event = new SimpleEvent();
////        event.setBody(log.getBytes());
////        JSONArray array = new StationHeartBeatSerilizar().getMultipleContentBuilder(event);
////        String indexIdField = "stationCode";
////        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
////
////
////        for (int i = 0; i < array.size(); i++) {
////            JSONObject data = array.getJSONObject(i);
////            String id = data.getString(indexIdField);
////            if(id!=null){
////                UpdateRequestBuilder updateRequestBuilder = this.client.prepareUpdate("cvf_workstation", "cvf_workstation", id)
////                        .setDoc(data.toJSONString(), XContentType.JSON).setUpsert(data);
////                bulkRequestBuilder.add(updateRequestBuilder);
////            }
////
////        }
////        BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
////        System.out.println(bulkResponse);
////
////    }

}
