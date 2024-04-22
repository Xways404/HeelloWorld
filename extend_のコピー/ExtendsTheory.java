package com.hspedu.extend_;

public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.name);
//      System.out.println(son.age);
        System.out.println(son.getAge());
        System.out.println(son.hobby);
    }
}
class GrandPa {//　爺クラス
    String name = "田中爺爺";
    String hobby = "旅行";
}
class Father extends GrandPa {// 親クラス
    String name = "田中パパ";
    private int age = 39;

    public int getAge() {
        return age;
    }

}
class Son extends Father {// 子クラス
    String name = "田中本人";
}
