package com.hspedu.reflection.class_;

import com.hspedu.Cat;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * クラスクラスの特徴まとめ
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //クラスクラスの図
        //Classもクラスであり、そのためobjectを継承している
        //Classはnewすることができない、システムによって構築されている
//        Cat cat = new Cat();
        //
        Class aClass = Class.forName("com.hspedu.Cat");
        Class aClass1 = Class.forName("com.hspedu.Cat");
        System.out.println(aClass.hashCode());
        System.out.println(aClass1.hashCode());
        //
        //



    }
}
