package com.meeting.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 其原因是虚拟机中存在了两个ClassLoaderTest类，一个是由系统程序类加载器加载的，一个是由我们自己定义的类加载器加载的，所以属于两个独立的类。也就是说类的唯一性由类加载器和类本身决定。
 */
public class DifferentLoaderSameClassDemo {
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream resourceAsStream = getClass().getResourceAsStream(fileName);

                    if (resourceAsStream == null)
                        return super.loadClass(name);

                    byte[] b = new byte[resourceAsStream.available()];
                    resourceAsStream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj =  myLoader.loadClass("com.meeting.jvm.classloader.DifferentLoaderSameClassDemo").newInstance();
        System.out.println(obj.getClass());

        System.out.println(obj instanceof com.meeting.jvm.classloader.DifferentLoaderSameClassDemo);
    }

}
