package com.hspedu.static_.innerclass;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        f1(new Il() {
            @Override
            public void show() {
                System.out.println("this is a beautiful show");
            }
        });
        f1(new Picture());
    }
    public static void f1(Il il) {
        il.show();
    }
}
interface Il {
    void show();
}
class Picture implements Il {
    @Override
    public void show() {
        System.out.println("this is a beautiful show");
    }
}
