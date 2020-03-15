package com.meeting.jvm.classloader;

/**
 * 通过数组引用来引用类，不会触发此类的初始化
 */
public class NotInitializationDemo2 {
    public static void main(String[] args) {
        SuperClass[] s_list=new SuperClass[10];
        /**
         * 运行结果无
         */
    }
}

