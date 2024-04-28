package com.hspedu.static_;

public class StaticDetail {
    public static void main(String[] args) {
     B b = new B();
//        System.out.println(B.n1);
        System.out.println(b.n2);
    //クラス名からでもアクセス可能
     System.out.println(C.name);

    }
}
class B {
    public int n1 = 100; //インスタンス変数
    public static int n2 = 200; //クラス変数　静的
}
class C {
    public static String name = "Beijing";
}

