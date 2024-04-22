package com.hspedu.poly_.objpoly;

public class PolyObject {
    public static void main(String[] args) {
        //オブジェクトのポリモーフィズムの特徴
        Animal animal = new Dog();
        animal.cry();
        animal = new Cat();
        animal.cry();
    }
}
