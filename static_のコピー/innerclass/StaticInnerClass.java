package com.hspedu.static_.innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
    }
}
class Outer10 {
    private int n1 = 10;
    private static String name = "jack";

    public static void cry(){}

    static class Inner10 {
        public void say() {
            System.out.println(name);
            cry();
        }
    }
    public void m1() {
        Inner10 inner10 = new Inner10();
        inner10.say();
    }
}
