package com.hspedu.static_.innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}
class Outer04 {
    private int n1 = 10;
    public void method () {
//        インターフェスに基づいてのインナークラス
//        匿名クラス
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("Tiger crying");
            }
        };
        tiger.cry();
//        IA tiger = new Tiger();
//        tiger.cry();

        Father jack = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名クラスがtestメソッドをオーバーライダー");
            }
        };
        System.out.println(jack.getClass());
        jack.test();
    }
}

interface  IA {
    public void cry();
}
//class Tiger implements IA {
//
//    @Override
//    public void cry() {
//        System.out.println("Tiger cry");
//    }
//}
class Father {
    public Father(String name) {

    }
    public void test() {

    }
}

