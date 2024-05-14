package com.hspedu.reflection.class_;

import com.hspedu.Car;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {

        //Class.forName
        String classAllPath = "com.hspedu.Car";//設定ファイルの読み取りに通じて
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //クラス名.class、応用場面:引数をパス
        Class cls2 = Car.class;
        System.out.println(cls2);

        //オブジェクト.getClass(),応用場面：オブジェクトのインスタンスが存在する場合
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //クラスローダーで（４種類）クラスのClassオブジェクトをゲット
        //まずクラスローダーをゲットcar
        ClassLoader classLoader = car.getClass().getClassLoader();
        //ローダーに通じてClassオブジェクトをゲット
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //cls1234は全部同じオブジェクトである
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //基本データ型
        //ジェネリクスにあるラッパークラスint -> Integerを自動転換する
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//出力はintのまま,基底ではInteger

        //基本データ型に応じるラッパークラスは、.TYPEでClassクラスのオブジェクトをゲットできる
        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        System.out.println(type);
        System.out.println(integerClass.hashCode());
        System.out.println(type.hashCode());
    }
}
