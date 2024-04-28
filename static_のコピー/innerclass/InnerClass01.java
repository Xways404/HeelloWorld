package com.hspedu.static_.innerclass;

public class InnerClass01 {
    public static void main(String[] args) {

    }
}
class Outer {//外部クラス
    private int n1 = 100;//属性

    public Outer(int n1) {//constractor
        this.n1 = n1;
    }

    public void m1() { //Outerのメソッド
        System.out.println("m1()");
    }
    {
        System.out.println("コードブロック");
    }
    class Inner {//内部クラス、外部クラスの内部にあるため


    }
}
