package com.meeting.jvm.source.code.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cat extends Animal {
    private String name;

    public Cat(String name) {
        super(name);
        this.name = name;
        super.name = name;
        List<int[]> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        //自动装箱
        List<Integer> list = Arrays.asList(1,2,3,null);
        int sum = 0 ;
        for(int i :list){
            //自动拆箱的时候会抛出异常（算数运算会触发自动拆箱）
            sum += i;
        }
        System.out.println(sum);
    }
}
