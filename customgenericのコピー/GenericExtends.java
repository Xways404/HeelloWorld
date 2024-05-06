package com.hspedu.customgeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */

public class GenericExtends {
    public static void main(String[] args) {

        Object xx = new String("xx");

        //ジェネリクスは継承性を持っていない
        //List<Object> list = new ArrayList<String>();

        //ワイルドカードの説明
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //境界のないワイルドカード<?>は　alloflist can be used
        printCollection(list1);
        printCollection(list2);
        printCollection(list3);
        printCollection(list4);
        printCollection(list5);
        //上限境界のワイルドカード<? extends AA>は、AAクラスとAAクラスの子クラスを受け
//        printCollection2(list1);
//        printCollection2(list2);
        printCollection2(list3);
        printCollection2(list4);
        printCollection2(list5);
        //下限境界のワイルドカード<? super AA>は、子クラスと上位にある親クラスを受け入れる　、
        printCollection3(list1);
//        printCollection3(list2);
        printCollection3(list3);
//        printCollection3(list4);
//        printCollection3(list5);






    }
    //メソッド立ち上げ
    // ?を用いたジェネリックタイプを、ワイルドカード型と呼びます
    ////List<?>は　ジェネリックなクラスは全て受け付ける
    //境界のないワイルドカード型（<?>）
    public static void printCollection(List<?> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
    //上限境界ワイルドカード型（<? extends T>）
    //AA、またはAAの子クラスを受け入れることができる
    public static void printCollection2(List<? extends AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
    //下限境界ワイルドカード型（<? super T>）
    //子クラスAA、AAとAAの親クラスを受け入れ、直接親クラスを受けれん
    public static void printCollection3(List<? super AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }


}

class AA {

}

class BB extends AA {

}

class CC extends BB {

}

