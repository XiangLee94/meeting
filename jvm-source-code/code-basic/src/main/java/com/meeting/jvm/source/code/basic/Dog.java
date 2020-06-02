package com.meeting.jvm.source.code.basic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Dog {
    public final Object lock = new Object();

    public void test1() {
        synchronized (lock) {
            System.out.println("nima");
        }
    }

    public void test2() {
        synchronized (lock) {
            System.out.println("wocao");
        }
    }

    public void test3() throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().monitorEnter(lock);
        System.out.println("gundu");
    }

    public void test4() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("xiba");
        getUnsafe().monitorExit(lock);
    }


    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");

        singleoneInstanceField.setAccessible(true);

        return (Unsafe) singleoneInstanceField.get(null);
    }

    public native void method();

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.method();
    }
}
