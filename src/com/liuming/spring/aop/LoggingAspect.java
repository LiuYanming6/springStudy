package com.liuming.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 刘艳明
 * @Date: 19-5-15 上午7:56
 *
 * @Order 值越小,切面优先级越高
 */

@Order(2)
@Aspect
@Component
public class LoggingAspect {

    /*
    切入点表达式, 可以通过方法名被引用
     */
//    @Pointcut("execution(* com.liuming.spring.aop.ICalculator.*(*,*))")
    @Pointcut("execution(* com.liuming.spring.aop.ICalculator.*(..))")
    public void declareJointCut(){}

    //    @Before("execution(public int com.liuming.spring.aop.ICalculator.add(int, int))")
    @Before("declareJointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("----------------------------------------------");
        String methodNmae = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodNmae + " Before with " + args);
    }

    @After("declareJointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodNmae = joinPoint.getSignature().getName();
        System.out.println("The method " + methodNmae + " After ");
    }

    @AfterReturning(value = "declareJointCut()", returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        String methodNmae = joinPoint.getSignature().getName();
        System.out.println("The method " + methodNmae + " AfterReturning result= " + result);
    }


    @AfterThrowing(value = "declareJointCut()", throwing = "ex")
    public void afterReturnMethod(JoinPoint joinPoint, Exception ex) {
        String methodNmae = joinPoint.getSignature().getName();
        System.out.println("The method " + methodNmae + " AfterThrowing result= " + ex);
    }

    //like 动态代理
    @Around("declareJointCut()")
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
