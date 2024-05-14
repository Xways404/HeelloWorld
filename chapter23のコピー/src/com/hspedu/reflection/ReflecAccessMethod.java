package com.hspedu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //Bossクラスに応じるClassオブジェクトをゲット
        Class<?> bossCls = Class.forName("com.hspedu.reflection.Boss");
        //オブジェクト作成
        Object o = bossCls.newInstance();
        //public のhiメソッドをコールする
//        Method hi = bossCls.getMethod("hi");
        //hiメソッドオブジェクトをゲット
        Method hi1 = bossCls.getDeclaredMethod("hi", String.class);
        //コール
        hi1.invoke(o, "我是你二舅");

        Method say = bossCls.getDeclaredMethod("say",int.class, String.class, char.class);
        say.setAccessible(true);
        say.invoke(o, 100, "我是你大爷");


    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {//コンストラクター
    }

    private static String say(int n, String s, char c) {//静的メソッド
        return n + " " + s + " " + c;
    }

    public void hi(String s) {//一般メソッド
        System.out.println("hi " + s);
    }
}
