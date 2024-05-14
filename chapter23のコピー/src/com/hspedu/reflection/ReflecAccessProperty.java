package com.hspedu.reflection;

import java.lang.reflect.Field;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //Studentクラスに応じるClassオブジェクトをゲット
        Class<?> stuClass = Class.forName("com.hspedu.reflection.Student");
        //オブジェクト作成
        Object o = stuClass.newInstance();//oの実行型がStudentになってる
        System.out.println(o.getClass());
        //リフレクションでageフィールドオブジェクトを操作
        Field age = stuClass.getField("age");
        age.set(o, 88);//リフレクションに通じてフィールドを操作できる
        System.out.println(o);//
        System.out.println(age.get(o));//直接ageフィールドの値を戻す

        //リフレクションでnameフィールドオブジェクトを操作
        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);///name対してチート技、強制的にアクセスして操作する
        name.set(o,"woshinibaba");
        System.out.println(o);
        System.out.println(name.get(o));
        System.out.println(name.get(null));




    }
}
class Student {
    public int age;
    private static String name;
    public Student() {

    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}