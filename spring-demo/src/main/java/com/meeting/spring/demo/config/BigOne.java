package com.meeting.spring.demo.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 可以通过实现 InitializingBean,DisposableBean 编写bean初始化方法和销毁方法
 */
public class BigOne implements InitializingBean, DisposableBean {
    private String name = "wan wan";

    @Override
    public void destroy() throws Exception {
        System.out.println("我来了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我溜了");
    }
}
