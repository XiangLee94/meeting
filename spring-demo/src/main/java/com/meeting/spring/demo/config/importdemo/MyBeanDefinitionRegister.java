package com.meeting.spring.demo.config.importdemo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 实现ImportBeanDefinitionRegistrar来通过@Import注解导入bean，可以自定义bean名称
 */
public class MyBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition jsonObjectBeanDefinition = new RootBeanDefinition(JSONObject.class);
        registry.registerBeanDefinition("jsonObject",jsonObjectBeanDefinition);
    }
}
