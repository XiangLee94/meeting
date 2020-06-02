package com.meeting.jvm.classloader;

public class GetClassDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<GetClassDemo> demoClass = GetClassDemo.class;
        Class<GetClassDemo> demoClass1 = (Class<GetClassDemo>) ClassLoader.getSystemClassLoader().loadClass("com.meeting.jvm.classloader.GetClassDemo");
        Class<GetClassDemo> demoClass2 = (Class<GetClassDemo>) Class.forName("com.meeting.jvm.classloader.GetClassDemo");
        GetClassDemo getClassDemo = new GetClassDemo();
        Class<GetClassDemo> demoClass3 = (Class<GetClassDemo>) getClassDemo.getClass();
        System.out.println(getStep(4));
    }


    public static int getStep(int count){
        int pre = 1;
        int cur = 2;
        if(count == 1) return pre;
        if(count == 2) return cur;
        for(int i = 3;i <= count;i ++){
            int temp = cur;
            cur = pre +cur;
            pre = temp;
        }
        return cur;
    }


}
