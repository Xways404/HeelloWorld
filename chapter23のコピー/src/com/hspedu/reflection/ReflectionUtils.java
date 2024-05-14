package com.hspedu.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * リフレクションに通じてクラスの情報
 */
public class ReflectionUtils {
    public static void main(String[] args) {


    }
    @Test
    public void api_02() throws ClassNotFoundException, NoSuchMethodException {
        //Classオブジェクトをゲット
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        //getDeclaredFields: クラスでの全てのフィールドをゲット
        Field[] personFields = personCls.getDeclaredFields();
        for (Field field : personFields) {
            System.out.println("クラスでの全てのフィールド"  + field.getName() +
            " このフィールドの修飾子の値　" + field.getModifiers()
            + " このフィールドのタイプ　" + field.getType());
        }
        //getDeclaredMethods: 本クラスの全てのメソッドをゲット
        Method[] personMethods = personCls.getDeclaredMethods();
        for (Method method : personMethods) {
            System.out.println("本クラスの全てのメソッド " + method.getName()
            + " このメソッドのアクセス修飾子 " + method.getModifiers()
            + " このメソッドの戻り型 " + method.getReturnType());
            //変数値
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }



    }

    @Test
    public void api_01() throws ClassNotFoundException, NoSuchMethodException {
        //Classオブジェクトをゲット
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");

        //getName: 全クラス名
        System.out.println(personCls.getName());
        //getSimpleName: 略クラス名
        System.out.println(personCls.getSimpleName());
        //getFields: publicの全ての修飾フィールドををゲット、本クラス及び親クラス
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本クラス及び親クラスのフィールド " + field.getName());
        }
        //getDeclaredFields: クラスでの全てのフィールドをゲット
        Field[] personFields = personCls.getDeclaredFields();
        for (Field field : personFields) {
            System.out.println("クラスでの全てのフィールド"  + field.getName());
        }
        //getMethods: publicでの全ての修飾フィールドをゲット、本クラス及び親クラス
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本クラス及び親クラスnoMethods " + method.getName());
        }
        //getDeclaredMethods: 本クラスの全てのメソッドをゲット
        Method[] personMethods = personCls.getDeclaredMethods();
        for (Method method : personMethods) {
            System.out.println("本クラスの全てのメソッド " + method.getName());
        }
        //getConstructors: publicでの修飾コンストラクターを全てゲット、本クラス及び親クラス
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本クラス及び親クラスコンストラクター " + constructor.getName());
        }
        //getDeclaredConstructors:　本クラスの全てのコンストラクターをゲット
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("本クラスの全てのコンストラクター " + constructor.getName());
        }
        //getPackage: パッケージの形式で戻す、パッケージ情報
        System.out.println(personCls.getPackage());
        //getSuperClass: Classの形式で親クラスの情報が戻す
        Class<?> superclass = personCls.getSuperclass();
        System.out.println(superclass);
        //getInterfaces: Class[]形式でインターファース情報が返される
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
        //getAnnotations: 注釈の情報が返される
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


    }
}
class A {
    public String hobby;
    public A() {}
    public void hi() {

    }
}
interface IA {}
interface IB {}
class Person extends A implements IA, IB {
    //フィールド
    public String name;
    protected int age;
    String job;
    private double sal;
    //コンストラクター
    public Person() {}
    public Person(String name) {}
    private Person(String name, int age) {}

    //メソッド
    public void m1() {

    }
    protected void m2() {

    }
    void m3() {

    }
    private void m4() {

    }
}
