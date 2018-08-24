package com.example.wenda.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * Created by Administrator on 2018/8/23 0023.
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.example.wenda.controller.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder sb = new StringBuilder();
        for(Object arg : joinPoint.getArgs()){
            sb.append("arg"+ arg.toString() + "/");
        }
        logger.info("before method" + sb.toString());
    }
    @After("execution(* com.example.wenda.controller.*.*(..))")
    public void AfterMethod(){
        logger.info("after method");
    }
}
