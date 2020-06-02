package com.meeting.concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        testInheritableThreadLocalWithExecutor();
    }

    private static void testThreadLocal() throws InterruptedException {
        final ThreadLocal<String> local = ThreadLocal.withInitial(() -> Thread.currentThread().getName());
        System.out.println(local.get());
        for (int i = 10; i < 20; i++) {
            System.out.println("set local to " + i);
            local.set("" + i);
            new Thread(() -> {
                System.out.println(local.get());
            }).start();
            Thread.sleep(100);
        }
    }

    private static void testInheritableThreadLocal() throws InterruptedException {
        final InheritableThreadLocal<String> local = new InheritableThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return Thread.currentThread().getName();
            }
        };
        System.out.println(local.get());
        for (int i = 10; i < 20; i++) {
            System.out.println("set local to " + i);
            local.set("" + i);
            new Thread(() -> {
                System.out.println(local.get());
            }).start();
            Thread.sleep(100);
        }

    }


    private static void testInheritableThreadLocalWithExecutor() throws InterruptedException {
        final InheritableThreadLocal<String> local = new InheritableThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return Thread.currentThread().getName();
            }
        };
        System.out.println(local.get());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 10; i < 20; i++) {
            System.out.println("set local to " + i);
            local.set("" + i);
            executor.submit(() -> {
                System.out.println(local.get());
            });
            Thread.sleep(100);
        }
        executor.shutdown();

    }


}
