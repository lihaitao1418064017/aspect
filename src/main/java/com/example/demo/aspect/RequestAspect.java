package com.example.demo.aspect;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.demo.annotation.LoginMsg;
import com.example.demo.annotation.RequestAnnotation;
import com.example.demo.entity.LoginMessage;
import com.example.demo.service.LoginMessageService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
* @Description:
* @Author:         LiHaitao
* @CreateDate:     2018/12/21 15:39
* @UpdateUser:
* @UpdateDate:
* @UpdateRemark:
* @Version:        1.0.0
*/
@Component
@Aspect
public class RequestAspect {
    /**
     * 1）execution(* *(..))
     //表示匹配所有方法
     2）execution(public * com. example.controller.*(..))
     //表示匹配com. example.controller中所有的public方法
     3）execution(* com. example.controller..*.*(..))
     //表示匹配com. example.controller包及其子包下的所有方法
     ---------------------
     */


    private final static Logger logger = LoggerFactory.getLogger(RequestAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.UserController.*(..)))")
    public void logRequest(){

    }

    @Before("logRequest()")
    public void before(JoinPoint point) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        RequestAnnotation requestAnnotation=method.getAnnotation(RequestAnnotation.class);
        logger.info("请求模块={}",requestAnnotation.value());
//url
        logger.info("请求url={}", request.getRequestURI());

        //method
        logger.info("请求方式={}", request.getMethod());

        //ip
        logger.info("请求ip={}", request.getRemoteAddr());

        //method
        logger.info("请求类方法class_method={}", point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());

        //param
        logger.info("参数={}", point.getArgs());

    }
    @After("logRequest()")
    public void doAfter(){
        logger.info("---------------请求以后-------------");
    }

    @AfterReturning(returning="obj", pointcut = "logRequest()")
    public void doAfterReturnig(Object obj){
        logger.info("reponse={}", obj);
    }

    @AfterThrowing(value = "logRequest()",throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint,NullPointerException exception){
        logger.info("- - - - - 后置异常通知 - - - - -{}",exception.getMessage());
    }



}
