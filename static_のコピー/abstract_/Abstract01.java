package com.hspedu.static_.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
    }
}
//抽象メソッドをするには抽象クラスにせんけっりゃならぬ
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    //eatメソッドを実現をしても意味がない
    //親クラスがまだ不確定問題がある
    //このメソッドを抽象メソッド
    //抽象メソッドとは、まだ実現されてないメソッドである
    public abstract void eat();
}
