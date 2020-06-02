package com.meeting.spring.demo.config.importdemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * 实现ImportSelector通过@Import注解导入bean,bean名称是类全限定名
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.alibaba.fastjson.JSONObject"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
