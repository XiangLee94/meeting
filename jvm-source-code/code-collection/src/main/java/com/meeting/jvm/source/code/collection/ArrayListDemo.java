package com.meeting.jvm.source.code.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        testForEachRemove();
    }

    private static void testForEachRemove() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "b", "c", "d"));
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if (s.equals("c")) {
                list.remove("b");
                list.add("e");
            }

        }
        System.out.println(list);

    }
}
