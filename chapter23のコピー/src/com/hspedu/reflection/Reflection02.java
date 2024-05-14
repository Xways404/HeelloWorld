package com.hspedu.reflection;

import com.hspedu.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
//        m1();
        m2();
        m3();

    }

//    public static void m1() {
//        Cat cat = new Cat();
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 90000000; i++) {
//            cat.hi();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("m1: " + (end - start));
//    }

    //リフレクションhi
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("com.hspedu.Cat");
        Object object = cls.newInstance();
        Method hi = cls.getMethod("hi");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(object);//リフレクションコールメソッド
        }
        long end = System.currentTimeMillis();
        System.out.println("m2: " + (end - start));
    }
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("com.hspedu.Cat");
        Object object = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(object);//リフレクションコールメソッド
        }
        long end = System.currentTimeMillis();
        System.out.println("m2: " + (end - start));
    }
}
