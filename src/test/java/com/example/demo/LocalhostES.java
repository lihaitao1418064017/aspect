package com.example.demo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.entity.User;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

/**
 * @author LiHaitao
 * @description Main:
 * @date 2018/12/25 17:41
 **/
@SuppressWarnings("all")
public class LocalhostES {

    Client c;

    @Before
    public void test() throws UnknownHostException {
        // 设置集群名称
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();
        // 创建client
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddresses(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        c = client;
        System.out.println(client.toString() + "<-------------------------");
    }

    /**
     * 查询测试
     */
    @Test
    public void testGet() {
        QueryBuilder match = QueryBuilders.matchAllQuery();
        SearchRequestBuilder search = c.prepareSearch("testindex")
                .setQuery(match)
                .setTypes("user")  //指定类型 可选
                .setFrom(0).setSize(1000); //分页 可选
        //搜索返回搜索结果
        SearchResponse response = search.get();
        //命中的文档
        SearchHits hits = response.getHits();
        JSONObject jsonObject;
        for (SearchHit hit : hits.getHits()) {
            Map<String, Object> map = hit.getSourceAsMap();
            jsonObject = JSONUtil.parseFromMap(map);
            System.out.println(jsonObject.get("id"));
            System.out.println(jsonObject.get("name"));
            System.out.println(new Date(Long.parseLong(jsonObject.get("born").toString())));
        }


        //命中总数
        Long total = hits.getTotalHits();
    }


    /**
     * 插入测试
     */
    @Test
    public void testPost() {
        JSONObject data = new JSONObject();
        data.put("id","1");
        data.put("name","李海涛");
        data.put("born",new Date());
        String id="1";
        UpdateRequestBuilder requestBuilder = c.prepareUpdate().setIndex("testindex").setType("user").setId(id)
                .setUpsert(data).setDoc(data);
        requestBuilder.execute().actionGet();

    }
    @Test
    public void testPut() {
        JSONObject data = new JSONObject();
        data.put("name","刘浩");
        data.put("born",new Date());
        data.put("age",24);
        String id="1";
        UpdateRequestBuilder requestBuilder = c.prepareUpdate().setIndex("testindex").setType("user").setId(id)
                .setUpsert(data).setDoc(data);
        requestBuilder.execute().actionGet();

    }
    /**
     * 删除记录
     */
    @Test
    public void testDelete(){
        String id="1";
        c.prepareDelete().setIndex("testindex").setType("user").setId(id).execute();
    }



}