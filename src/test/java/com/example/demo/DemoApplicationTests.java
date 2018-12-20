package com.example.demo;

import com.example.demo.entity.LogInfo;
import com.example.demo.entity.User;
import com.example.demo.service.LogInfoService;
import com.example.demo.service.UserService;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jnlp.UnavailableServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private LogInfoService logInfoService;
	@Autowired
	private UserService userService;

	@Test
	public void test(){
		//数据源1
		User user1 = userService.selectById(1L);
		System.out.println(user1.getName());


		//数据源1
		LogInfo logInfo=new LogInfo();
		logInfo.setOperation("123123");
//		LogInfo user3 = logInfoService.selectById(1L);
		logInfoService.insert(logInfo);
//		System.out.println(user3.getCreateTime());
	}

}

