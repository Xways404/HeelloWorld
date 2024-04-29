package com.hspedu.homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();
        Animal dog = new Dog();
        dog.shout();
    }
}
abstract class Animal {
    public abstract void shout();
}
class Cat extends Animal {

    @Override
    public void shout() {
        System.out.println("Cat Miaomiao");
    }
}
class Dog extends Animal {

    @Override
    public void shout() {
        System.out.println("Dog Wangwang");
    }
}

