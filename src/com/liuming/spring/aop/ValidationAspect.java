package com.liuming.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 下午2:15
 */
@Order(3)
@Aspect
@Component
public class ValidationAspect {

    @Before(value = "LoggingAspect.declareJointCut()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("aop validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
