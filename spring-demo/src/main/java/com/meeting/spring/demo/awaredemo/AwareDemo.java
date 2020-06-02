package com.meeting.spring.demo.awaredemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class AwareDemo implements BeanFactoryAware {

    public static void main(String[] args) {
        AwareDemo awareDemo = new AwareDemo();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //可以获取到BeanFactory，XXXAware就可以获取到XXX的对象，spring会将其传入(setXXX)
        Object bean = beanFactory.getBean("");
    }
}
