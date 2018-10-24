package com.zy.aspect;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Configuration//定义一个切面
public class LogRecordAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

    // 定义切点Pointcut
    @Pointcut("execution(* com.zy.controller..*.*(..))")
    public void excudeService() {

    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        //请求地址
        String requestURI = request.getRequestURI();
        long beforeTime=System.currentTimeMillis();
        Map<String, String[]> parameterMap = request.getParameterMap();
        logger.info("请求地址：{}，请求参数：{}",requestURI, JSON.toJSONString(parameterMap));
        // result的值就是被拦截方法的返回值
        Object result = pjp.proceed();
        long afterTime=System.currentTimeMillis();
        logger.info("返回参数：{}", JSON.toJSONString(result));
        logger.info("请求结束：{} , 耗时：{}ms",requestURI,afterTime-beforeTime);
        return result;
    }
}