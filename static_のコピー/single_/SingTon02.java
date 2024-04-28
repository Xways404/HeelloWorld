package com.hspedu.static_.single_;

public class SingTon02 {
    public static void main(String[] args) {

        System.out.println(Cat.n1);

        Cat instance = Cat.getInstance();
        System.out.println(instance);

        Cat instance2 = Cat.getInstance();
        System.out.println(instance2);

    }
}
//実際プログラムを運行するときに、Catオブジェクトを一つしか作れないようにする
class Cat {
    private String name;
    public static int n1 = 99;
    private static Cat cat;

    //1.私有化のコンストラクタを作成
    //2.静的static属性を定義する
    //3.公共系のstaticメソッドを提供し、Catオブジェクトを戻す
    private Cat(String name) {
        this.name = name;
    }
    public static Cat getInstance() {
        if(cat == null) {
            cat = new Cat("mermer");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
