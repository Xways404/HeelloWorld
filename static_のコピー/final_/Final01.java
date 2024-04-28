package com.hspedu.static_.final_;

public class Final01 {
    public static void main(String[] args) {

    }
}
final class A { }
//クラスの前にfinalをつければ継承できなくなる
//class B extends A { }

class C {
    //もしhiメソッドをオーバーライダーにされてはいけないと要求するのであれば
    //finalを使って、修飾することができ、制限をかける
    public final void hi() {
    }
}
class D extends C {
//    @Override
//    public void hi() {
//        System.out.println("Cクラスのhiメソッドをオーバーライダーした");}
}
class E {
    public final double TAX_RATE = 0.08;
}
class F{
    public void cry() {
        final double NUM = 0.01;
//        NUM = 0.9;
        System.out.println(NUM);
    }
}