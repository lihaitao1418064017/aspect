package com.example.demo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.entity.User;
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
import java.util.Map;

/**
 * @author LiHaitao
 * @description Main:
 * @date 2018/12/25 17:41
 **/
public class Main {

    Client c;
    @Before
    public void test() throws UnknownHostException {
        // 设置集群名称
        Settings settings = Settings.builder().put("cluster.name", "es-test").build();
        // 创建client
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddresses(new TransportAddress(InetAddress.getByName("10.255.228.103"), 9300));
        c=client;
        System.out.println(client.toString()+"<-------------------------");
    }
    @Test
    public void testGet(){
        QueryBuilder match = QueryBuilders.matchAllQuery();
        SearchRequestBuilder search = c.prepareSearch("cvf_device")
                .setQuery(match)
                .setTypes("cvf_device")  //指定类型 可选
                .setFrom(0).setSize(1000); //分页 可选
        //搜索返回搜索结果
        SearchResponse response = search.get();
        //命中的文档
        SearchHits hits = response.getHits();
        //命中总数
        Long total = hits.getTotalHits();
        //循环查看命中值
        JSONObject jsonObject;
        for(SearchHit hit:hits.getHits()){
            //文档元数据
            String index = hit.getIndex();
            //文档的_source的值
            jsonObject = JSONUtil.parseFromMap(hit.getSourceAsMap());
            JSONObject data = new JSONObject();
            System.out.println(jsonObject.get("id"));
//            if (jsonObject!=null&&jsonObject.get("id")!=null){
//            String id=jsonObject.get("id").toString();
//            if (id!=null){
//            AWaLs66BRLca4UK-PWPe
//            AWaLs66BRLca4UK-PWO7
//            AWaLs66BRLca4UK-PWO_
//            AWaLs66BRLca4UK-PWPL
//            AWaLs66BRLca4UK-PWO9
//            c44cedce42954491868fa60ea937cb34
//            AWaLs66BRLca4UK-PWO6
//            AWaLs66BRLca4UK-PWO-
//            AWaLs66BRLca4UK-PWPf

            String id="AWaLs66BRLca4UK-PWO9";
            data.put("wlVpns", "[{\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":1}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":2}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":3}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":4}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":5}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":6}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":7}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":8}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":9}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":10}]");
            UpdateRequestBuilder requestBuilder = c.prepareUpdate().setIndex("cvf_device").setType("cvf_device").setId(id)
                    .setUpsert(data).setDoc(data);
            requestBuilder.execute().actionGet();
//            }

           /* String[] ids = {
                    "AWaLs66BRLca4UK-PWPe",
                    "AWaLs66BRLca4UK-PWO7",
                    "AWaLs66BRLca4UK-PWO",
                    "AWaLs66BRLca4UK-PWPL",
                    "AWaLs66BRLca4UK-PWO9",
                    "c44cedce42954491868fa60ea937cb34",
                    "AWaLs66BRLca4UK-PWO6",
                    "AWaLs66BRLca4UK-PWO-",
                    "AWaLs66BRLca4UK-PWPf",
                    "AWaLs66BRLca4UK-PWO_"
            };
            for (String id:ids) {
                data.put("wlVpns", "[{\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":1}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":2}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":3}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":4}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":5}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":6}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":7}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":8}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":9}, {\"wlVpnPppEncrypt\":0,\"wlVpnType\":0,\"wlVpnStatus\":0,\"wlVpnId\":10}]");
                UpdateRequestBuilder requestBuilder = c.prepareUpdate().setIndex("cvf_device").setType("cvf_device").setId(id)
                        .setUpsert(data).setDoc(data);
                requestBuilder.execute().actionGet();
            }*/
            }

        }


}
