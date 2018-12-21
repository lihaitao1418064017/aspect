package com.example.demo.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.demo.annotation.LogAnnotation;
import com.example.demo.annotation.LoginMsg;
import com.example.demo.entity.LogInfo;
import com.example.demo.entity.LoginMessage;
import com.example.demo.service.LogInfoService;
import com.example.demo.service.LoginMessageService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description LogAspect:
 * @Author LiHaitao
 * @Date 2018/12/20 10:09
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/
@Component
@Aspect
public class LogMsgAspect {

    @Autowired
    private LoginMessageService loginMessageService;


    @Pointcut("@annotation(com.example.demo.annotation.LoginMsg)")
    public void LogPointCut(){

    }

    @Around("LogPointCut()")
    public Object before(ProceedingJoinPoint point) throws Throwable {
        //保存日志
        saveLoginMsg(point);
        return point.proceed();
    }

    private void saveLoginMsg(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LoginMessage loginMessage=new LoginMessage();
        LoginMsg logAnnotation=method.getAnnotation(LoginMsg.class);


        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String username = new JSONUtils().toJSONString(args[0]);
            String password = new JSONUtils().toJSONString(args[1]);
            loginMessage.setUsername(username);
            loginMessage.setPassword(password);
        } catch (Exception e) {

        }
        loginMessage.setLoginTime(new Date());

        loginMessageService.registerMessage(loginMessage);
    }


}
