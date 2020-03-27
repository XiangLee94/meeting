package com.meeting.concurrency.basic;

public class InterruptDemo {
    private static int x;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                x++;
                //Thread的实例方法，查看线程的状态，不会清除中断标识
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("T1 被中断");
                    break;
                }
            }
            System.out.println("T1最后的状态"+Thread.currentThread().isInterrupted());
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                x++;
                //Thread的静态方法，作用于当前执行这个方法的线程，会清除中断状态
                if(Thread.interrupted()){
                    System.out.println("T2 被中断");
                    break;
                }
            }
            System.out.println("T2最后的状态"+Thread.currentThread().isInterrupted());
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                x++;
                //Thread的静态方法，作用于当前执行这个方法的线程，会清除中断状态
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("T3的sleep方法响应中断抛出异常，并将中断标识清除");
                }
                if(Thread.interrupted()){
                    System.out.println("T3 被中断");
                    break;
                }
            }
            System.out.println("T3最后的状态"+Thread.currentThread().isInterrupted());
        });
        t2.start();
        t1.start();
        t3.start();
        Thread.sleep(100);
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }
}
