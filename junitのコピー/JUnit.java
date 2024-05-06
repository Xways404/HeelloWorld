package com.hspedu.junit;

import org.junit.jupiter.api.Test;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class JUnit {
    public static void main(String[] args) {

//        new JUnit().m1();
//        new JUnit().m2();

    }
    @Test
    public void m1() {
        System.out.println("m1メソッドがコールされた");
    }
    @Test
    public  void m2() {
        System.out.println("m2メソッドがコールされた");
    }
}

