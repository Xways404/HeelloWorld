package com.hspedu.reflection.class_;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class AllTypeClass {
    public static void main(String[] args) {

        Class<String> cls1 = String.class;//外部クラス
        Class<Serializable> cls2 = Serializable.class;//インターフェース
        Class<Integer> cls3 = Integer.class;//配列
        Class<float[][]> cls4 = float[][].class;//二次元配列
        Class<Deprecated> cls5 = Deprecated.class;//注釈
        Class<Thread.State> cls6 = Thread.State.class;//列挙
        Class<Long> cls7 = long.class;//基本データ型
        Class<Void> cls8 = void.class;//void
        Class<Class> cls9 = Class.class;//クラスのクラス

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);





    }
}
