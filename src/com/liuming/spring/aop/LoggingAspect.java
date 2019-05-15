package com.liuming.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 上午7:56
 */

@Aspect
@Component
public class LoggingAspect {
    //    @Before("execution(public int com.liuming.spring.aop.ICalculator.add(int, int))")
    @Before("execution(* com.liuming.spring.aop.ICalculator.*(*,*))")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("----------------------------------------------");
        String methodNmae = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodNmae + " Before with " + args);
    }

    //fdfdfdfdddf
    @After("execution(* com.liuming.spring.aop.ICalculator.*(*, *))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodNmae = joinPoint.getSignature().getName();
        System.out.println("The method " + methodNmae + " After ");
    }

    @AfterReturning(value = "execution(* com.liuming.spring.aop.ICalculator.*(..))",
            returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        String methodNmae = joinPoint.getSignature().getName();
        System.out.println("The method " + methodNmae + " AfterReturning result= " + result);
    }


    @AfterThrowing(value = "execution(* com.liuming.spring.aop.ICalculator.*(..))",
            throwing = "ex")
    public void afterReturnMethod(JoinPoint joinPoint, Exception ex) {
        String methodNmae = joinPoint.getSignature().getName();
        System.out.println("The method " + methodNmae + " AfterThrowing result= " + ex);
    }

    //like 动态代理
    @Around("execution(* com.liuming.spring.aop.ICalculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        System.out.println("aroundMethod");
        String methodNmae = pjd.getSignature().getName();
        Object result = null;
        try {
            // like Before
            System.out.println("The method " + methodNmae);
            result = pjd.proceed();
            //like aop After
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // like aop AfterThrowing
        }
        //like aop AfterReturn
        return result;
    }

}
