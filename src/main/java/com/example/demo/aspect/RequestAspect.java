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
        logger.info("- - - - - 异常通知 - - - - -{}",exception.getMessage());
    }
    /**
     * 定义切入点的时候需要一个包含名字和任意参数的签名，还有一个切入点表达式，如execution(public * com.example.aop...(..))

     切入点表达式的格式：execution([可见性]返回类型[声明类型].方法名(参数)[异常])
     其中[]内的是可选的，其它的还支持通配符的使用：
     1) *：匹配所有字符
     2) ..：一般用于匹配多个包，多个参数
     3) +：表示类及其子类
     4)运算符有：&&,||,!

     切入点表达式关键词用例：
     1）execution：用于匹配子表达式。
     //匹配com.cjm.model包及其子包中所有类中的所有方法，返回类型任意，方法参数任意
     @Pointcut(“execution(* com.cjm.model...(..))”)
     public void before(){}

     2）within：用于匹配连接点所在的Java类或者包。
     //匹配Person类中的所有方法
     @Pointcut(“within(com.cjm.model.Person)”)
     public void before(){}
     //匹配com.cjm包及其子包中所有类中的所有方法
     @Pointcut(“within(com.cjm..*)”)
     public void before(){}

     3） this：用于向通知方法中传入代理对象的引用。
     @Before(“before() && this(proxy)”)
     public void beforeAdvide(JoinPoint point, Object proxy){
     //处理逻辑
     }

     4）target：用于向通知方法中传入目标对象的引用。
     @Before(“before() && target(target)
     public void beforeAdvide(JoinPoint point, Object proxy){
     //处理逻辑
     }

     5）args：用于将参数传入到通知方法中。
     @Before(“before() && args(age,username)”)
     public void beforeAdvide(JoinPoint point, int age, String username){
     //处理逻辑
     }

     6）@within ：用于匹配在类一级使用了参数确定的注解的类，其所有方法都将被匹配。
     @Pointcut(“@within(com.cjm.annotation.AdviceAnnotation)”)
     － 所有被@AdviceAnnotation标注的类都将匹配
     public void before(){}

     7）@target ：和@within的功能类似，但必须要指定注解接口的保留策略为RUNTIME。
     @Pointcut(“@target(com.cjm.annotation.AdviceAnnotation)”)
     public void before(){}

     8）@args ：传入连接点的对象对应的Java类必须被@args指定的Annotation注解标注。
     @Before(“@args(com.cjm.annotation.AdviceAnnotation)”)
     public void beforeAdvide(JoinPoint point){
     //处理逻辑
     }

     9）@annotation ：匹配连接点被它参数指定的Annotation注解的方法。也就是说，所有被指定注解标注的方法都将匹配。
     @Pointcut(“@annotation(com.cjm.annotation.AdviceAnnotation)”)
     public void before(){}

     10）bean：通过受管Bean的名字来限定连接点所在的Bean。该关键词是Spring2.5新增的。
     @Pointcut(“bean(person)”)
     public void before(){}
     ---------------------
     */


}
