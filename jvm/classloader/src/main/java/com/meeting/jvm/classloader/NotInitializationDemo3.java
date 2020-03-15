package com.meeting.jvm.classloader;

/**
 * 常量在编译阶段会被存入调用类的常量池中，本质上并没有引用到定义常量类类，所以自然不会触发定义常量的类的初始化
 */
public class NotInitializationDemo3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.value);
        /**
         * 运行结果
         * hello
         */
    }
}

class ConstClass {
    static {
        System.out.println("ConstClass init.");
    }

    public final static String value = "hello";
}