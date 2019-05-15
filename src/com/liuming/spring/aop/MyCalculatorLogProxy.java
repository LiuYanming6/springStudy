package com.liuming.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: 刘艳明
 * @Date: 19-5-14 上午9:29
 */

/*
动态代理
 */
public class MyCalculatorLogProxy {
    //要代理的对象
    private ICalculator target;

    public MyCalculatorLogProxy(ICalculator target) {
        this.target = target;
    }

    public ICalculator getLogProxy(){
        //代理对象由哪个类加载器加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型,即其中有拿些方法
        Class interfaces[] = new Class[]{ICalculator.class};
        //当调用代理对象其中的方法时,该执行的代码
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    String methodName = method.getName();
                    System.out.println("业务前日志:" + methodName); //like aop Before
                    result = method.invoke(target, args);
                    System.out.println("业务后日志:" + methodName); //like aop AfterReturn

                } catch (Exception e){
                    e.printStackTrace();
                    // like aop AfterThrowing 
                }
                //like aop After
                return result;
            }
        };
        ICalculator proxy = (ICalculator) Proxy.newProxyInstance(loader,interfaces,handler);

        return proxy;
    }
}
