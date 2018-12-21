package com.example.demo;

import com.example.demo.entity.LogInfo;
import com.example.demo.entity.LoginForm;
import com.example.demo.entity.User;
import com.example.demo.service.LogInfoService;
import com.example.demo.service.LoginFormService;
import com.example.demo.service.UserService;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.log.LogFormatUtils;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jnlp.UnavailableServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private LoginFormService logInfoService;
	@Autowired
	private UserService userService;

	@Test
	public void test(){
		//数据源1
		User user=new User();
		user.setName("1");
		user.setPassword("1");

		User user1 = userService.add(user);
		System.out.println(user1.getName());


		//数据源1
		LoginForm logInfo=new LoginForm();
		logInfo.setPassword(user1.getPassword());
		logInfo.setName(user1.getName());
//		LogInfo user3 = logInfoService.selectById(1L);
		logInfoService.add(logInfo);
//		System.out.println(user3.getCreateTime());
	}

}

