package com.hspedu.generic;

import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Generic01 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("jack", 10));
        arrayList.add(new Dog("tom", 20));
        arrayList.add(new Dog("lucy", 30));

        //間違えて別のオブジェクトを導入してしまったら、例外発生
        arrayList.add(new Cat("ru", 10));


        for (Object o : arrayList) {
//            Object -> Dogダウンキャストする
            Dog dog = (Dog) o;
            System.out.println(dog.getName() + " " + dog.getAge());
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