package com.meeting.concurrency.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 最简单的生产者消费者模型
 */
public class ProducerConsumerDemo {
    private static volatile int count = 1000;
    private static String value;

    public static void main(String[] args) {
        testProduceConsume2();
    }

    private static void testProduceConsume1() {
        byte[] lock = new byte[0];
        Thread producer = new Thread(() -> {
            synchronized (lock) {
                while (count > 0) {
                    if (value != null) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("set value" + count);
                    value = count + "";
                    count--;
                    lock.notify();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (count > 0) {
                synchronized (lock) {
                    if (value == null) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("get value" + value);
                    value = null;
                    lock.notify();
                }

            }
        });
        producer.start();
        consumer.start();
    }

    private static void testProduceConsume2() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread producer = new Thread(() -> {
            while (count > 0) {
                lock.lock();
                if (value != null) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("set value " + count);
                value = count + "";
                count--;
                condition.signal();
                lock.unlock();
            }
        });
        Thread consumer = new Thread(() -> {
            while (count > 0) {
                lock.lock();
                if (value == null) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("get value " + value);
                value = null;
                condition.signal();
                lock.unlock();
            }

        });
        producer.start();
        consumer.start();
    }
}
