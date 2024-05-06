package com.hspedu.generic.improve;

import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Generic02 {
    public static void main(String[] args) {

        //「<>」記号で囲まれたデータ型名をクラスやメソッドに付けることで、
        // Integer型やString型などの様々な型に対応する汎用的なクラスやメソッドを作る機能のこと
        //走査するする際に、objectじゃなくて直接Dogで可能
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("jack", 10));
        arrayList.add(new Dog("tom", 20));
        arrayList.add(new Dog("jim", 30));
        //束縛かけたから、Cat使用できない
//        arrayList.add(new Cat("tom", 40));

        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

    }
}
class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
