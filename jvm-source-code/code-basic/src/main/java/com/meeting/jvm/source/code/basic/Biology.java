package com.meeting.jvm.source.code.basic;

public interface Biology {
    public static final String name = null;

    default String getName(){
        return "";
    }
    default String getId(){
        return "";
    }
}
