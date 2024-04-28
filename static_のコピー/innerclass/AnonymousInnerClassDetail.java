package com.hspedu.static_.innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}
class Outer05 {
    private int n1 = 99;
    public void f1 () {
        //クラスに基づいての匿名クラスを作成する
        Person p = new Person() {
            @Override
            public void hi() {
                System.out.println("匿名クラスがhiメソッドオーバーライダー");
            }
        };
        p.hi();//実行する際に動的束縛される
        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名クラスがhiメソッドオーバーライダーhhhhhhhhasdf");
            }

            @Override
            public void ok(String str) {
                super.ok(str);
            }
        }.ok("jack");
}
class Person {
    public void hi() {
        System.out.println("person hi()");
    }
    public void ok(String str) {
        System.out.println("person ok() " + str);}
}
}


