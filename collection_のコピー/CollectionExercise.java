package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class CollectionExercise {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(new Dog("jack", 2));
        list.add(new Dog("tom", 3));
        list.add(new Dog("damn", 1312));

        //拡張for、
        System.out.println("======for====");
        for (Object dog :list) {
            System.out.println(dog);
        }
        //イテレータ
        System.out.println("======Iterator====");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println(dog);

        }


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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
