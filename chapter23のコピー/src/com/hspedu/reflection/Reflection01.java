package com.hspedu.reflection;

import com.hspedu.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Reflection01 {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();

        //リフレクションで解決する
        // クラスをロードする Classクラス型のオブジェクトが戻される
        Class cls = Class.forName(classfullpath);
        //clsに通じてロードしたクラスのオブジェクトインスタンスをゲットできる
        Cat o = (Cat)cls.newInstance();
        //clsに通じてロードしたクラスのメソッドオブジェクト
        //リフレクションでは、メソッドをオブジェクトとして扱える
        Method method1 = cls.getMethod(method);
        //コール
        System.out.println("=========================");
        method1.invoke(o);// メソッド.invoke(オブジェクト)

        //java.lang.reflect.Field:
        //nameをゲット
        //プライベート属性はゲットできない
        Field age = cls.getField("age");
        System.out.println(age.get(o));
        //コンストラクター
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
        //

    }
}
