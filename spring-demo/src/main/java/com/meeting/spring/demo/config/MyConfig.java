package com.meeting.spring.demo.config;

import com.alibaba.fastjson.JSONObject;
import com.meeting.spring.demo.config.importdemo.MyBeanDefinitionRegister;
import com.meeting.spring.demo.config.importdemo.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(JSONObject.class) //使用Import直接导入bean
//@Import(MyImportSelector.class) //实现ImportSelector，通过实现selectImports来导入bean
@Import(MyBeanDefinitionRegister.class) //实现ImportBeanDefinitionRegistrar，通过实现registerBeanDefinitions来注册导入bean
public class MyConfig {

    /**
     * 在不指定bean名称的情况下，默认是以方法名作为bean名 @Bean(name = "wanzi")
     * 在不指定Scope的情况下，所有的bean都是单实例的bean,而且是饿汉加载(容器启动实例就创建 好了)
     * @return
     */
    @Bean
    //@Scope(value = "prototype")
    public BigOne theBigOne(){
        //使用@Bean导入的bean，如果实现的初始化和销毁方法，这里如果是new 创建，则初始化方法不会执行，销毁方法会执行
        return new BigOne();
    }

}
