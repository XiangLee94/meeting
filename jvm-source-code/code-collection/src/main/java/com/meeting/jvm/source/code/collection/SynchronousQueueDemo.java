package com.meeting.jvm.source.code.collection;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    private String elementValue;

    public SynchronousQueueDemo(String elementValue) {
        this.elementValue = elementValue;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<SynchronousQueueDemo> synchronousQueue = new SynchronousQueue<>();
        SynchronousQueueDemo element = new SynchronousQueueDemo("alpha");
        synchronousQueue.put(element);
        SynchronousQueueDemo peekElement = synchronousQueue.peek();
        System.out.println(peekElement.elementValue);
    }
}
