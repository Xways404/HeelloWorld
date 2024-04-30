package com.hspedu.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ThrowsDetail {
    public static void main(String[] args) {
    }

    public void f2() {
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }
    public static void f1() {

    }
    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
}
class Father {
    public void method() throws RuntimeException {

    }
}
//子クラスがオーバーライド親クラスの時に、例外をスローする規定としては：子クラスがオーバーライドしたメソッドであること
//スローされた例外クラスも親子関係であること
class Son extends Father {
    public void method() throws NullPointerException {

    }
}

