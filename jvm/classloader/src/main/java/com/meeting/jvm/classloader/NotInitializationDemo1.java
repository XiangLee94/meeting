package com.meeting.jvm.classloader;

/**
 * 通过子类引用父类的静态字段，不会导致子类的初始化
 */
public class NotInitializationDemo1 {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        /**
         * 运行结果
         * super class init.
         * 123
         */
    }
}

class SuperClass {
    static {
        System.out.println("super class init.");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("sub class init.");
    }
}
