package com.example.demo.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.demo.annotation.LogAnnotation;
//import com.example.demo.datasources.DataSourceNames;
//import com.example.demo.datasources.annotation.DataSource;
import com.example.demo.entity.LogInfo;
import com.example.demo.service.LogInfoService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
public class LogAspect {

    @Autowired
    private LogInfoService logInfoService;


    @Pointcut("@annotation(com.example.demo.annotation.LogAnnotation)")
    public void LogPointCut(){

    }

    @Around("LogPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveLog(point, time);

        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LogInfo logInfo = new LogInfo();
        LogAnnotation logAnnotation=method.getAnnotation(LogAnnotation.class);
        if (logInfo != null) {
            //注解上的描述
            logInfo.setOperation(logAnnotation.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logInfo.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = new JSONUtils().toJSONString(args[0]);
            logInfo.setParams(params);
        } catch (Exception e) {

        }
        logInfo.setCreateTime(new Date());

        logInfoService.insert(logInfo);
    }


}
