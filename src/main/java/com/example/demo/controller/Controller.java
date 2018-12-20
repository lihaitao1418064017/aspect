//package com.example.demo.controller;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.*;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.nio.charset.Charset;
//import java.util.Date;
//import java.util.HashMap;
//
///**
// * @Description controller:
// * @Author LiHaitao
// * @Date 2018/12/14 15:23
// * @UpdateUser
// * @UpdateDescrip
// * @UpdateDate
// * @Version 1.0.0
// **/
//@RestController
//@RequestMapping("/get")
//public class Controller {
//
//    @GetMapping("/hello")
//    String index() throws InterruptedException {
//        Thread.sleep(10*1000);
//        System.out.println("已经请求到接口");
//        return "hello world";
//    }
//
//    private static RestTemplate INSTANCE = new RestTemplateBuilder().additionalMessageConverters(new StringHttpMessageConverter(Charset.forName("UTF-8"))).build();
//
//
//    @Scheduled(cron = "0/1 * * * * ?")
//    public void printSay() {
//        System.out.println("start-------->!"+new Date());
//        ResponseEntity<String> exchange = INSTANCE.exchange("http://localhost:8080/get/hello", HttpMethod.GET, createHttpEntity(new HashMap<>()), String.class);
//        System.out.println("请求结束");
//        System.out.println(exchange.getBody());
//    }
//
//    private static <T> HttpEntity createHttpEntity(T body) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
//        if (null != body) {
//            return new HttpEntity<>(JSON.toJSONString(body), headers);
//        } else {
//            return new HttpEntity<>(headers);
//        }
//    }
//
//}
//
