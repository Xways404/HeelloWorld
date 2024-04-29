package com.hspedu.homework;

import javax.naming.NamingEnumeration;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}
class A {
    private String NAME = "Hello";
    public void f1() {
        class B {
            private final String NAME = "LIMI";
            public void show() {
                System.out.println(NAME + A.this.NAME);
            }
        }
        B b = new B();
        b.show();
    }
}
