package com.hspedu.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master tom = new Master("Tom");
        Dog dog = new Dog("Big Yellow");
        Bone bone = new Bone("Big Bone");

        tom.feed(dog, bone);

        Cat cat = new Cat("Catty");
        Fish fish = new Fish("マグロ");
        System.out.println("=================");
        tom.feed(cat, fish);
    }
}
