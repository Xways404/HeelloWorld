package com.hspedu.customgeneric;

import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 *　ジェネリクスメソッドの使い方
 */
public class CustomMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        //メソッドを呼び出しする際に、パラメータを入力すれば、コンパイラが型を自動確認
        //いわゆる、型パラメータの互換性
        car.fly("BMW", 100);


    }
}
//ジェネリックなメソッドは、一般クラスとジェネリックなクラスで定義できる
class Car {
    public void run() {

    }
    //<T, R>はジェネリクス
    //flyに提供して使われる
    public<T, R> void fly(T t, R r) {
        System.out.println(t.getClass());
        System.out.println(r.getClass());


        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(), 11.3f);

    }
}
class Fish<T, R> {//ジェネリックなクラス
    public void run() {

    }
    public<U, M> void eat(U u, M m) {//ジェネリックなメソッド

    }
    //hiメソッドはジェネリックなメソッドではない
    //hiメソッドはクラスが宣言されたジェネリスクで使われた
    public void hi(T t) {
    }
    //ジェネリックなメソッドはクラスが宣言したジェネリクスを使えて、
    //さらに、自分が宣言したジェネリクスもできる
    public<K> void hello(R r, K k) {
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }
}

