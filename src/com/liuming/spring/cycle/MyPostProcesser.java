package com.liuming.spring.cycle;

import com.liuming.spring.autowire.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @Author: 刘艳明
 * @Date: 19-5-12 下午12:15
 */
public class MyPostProcesser implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + bean + ","  + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + bean + "," + beanName);
        if (bean instanceof Car){
            //哈哈 我把所有的车都掉包了
            ((Car)bean).setBrand("自行车");
        }
        return bean;
    }
}
