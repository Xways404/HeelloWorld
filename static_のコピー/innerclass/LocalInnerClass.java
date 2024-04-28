package com.hspedu.static_.innerclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}
class Outer02 {
    private int n1 = 100;
    private void m2() {
        System.out.println("m2");
    }
    public void m1() {
        final class Inner02 {
            public void f1() {
                System.out.println(n1);
                m2();
            }
        }
        Inner02 inner02 = new Inner02();
        inner02.f1();
//        class Inner03 extends Inner02 {
//
//        }
    }
}
