package com.hspedu.static_.innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();
    }
}
class Outer08 {
    private int n1 = 10;
    public String name = "Jack";
    class Inner08 {
        public void say() {
            System.out.println(n1 + name);
        }
    }
    public void t1() {
        Inner08 inner08 = new Inner08();
        inner08.say();
    }
}
