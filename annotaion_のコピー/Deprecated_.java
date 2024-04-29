package com.hspedu.annotaion_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Deprecated_ {
    public static void main(String[] args) {
        A a = new A();
    }
}
//deprecatedタグとは非推奨の意味である
//使うのはお勧めしないけど、使うことはできる
@Deprecated
class A {
    public int n1 = 10;
    public void hi() {

    }
}
