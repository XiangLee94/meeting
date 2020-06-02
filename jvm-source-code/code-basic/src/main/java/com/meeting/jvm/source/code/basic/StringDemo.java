package com.meeting.jvm.source.code.basic;

import sun.nio.ch.DirectBuffer;

import java.lang.ref.Reference;

public class StringDemo {
    public static void main(String[] args) {
        String a = "wdnmd";
        int i = System.identityHashCode(a);
        a.intern();
        int i1 = System.identityHashCode(a);
        System.out.println(i);
        System.out.println(i1);
        System.out.println('\uD800');
        System.out.println(new String("1").hashCode());
        System.out.println(new String("1").hashCode());

    }
}
