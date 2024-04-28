package com.hspedu.static_;

public class CodeBlockDetail  {
    public static void main(String[] args) {
        //子クラスのオブジェクトのインスタンス(new)を作成するときに、呼び出される
//        AA aa = new AA();
        //子クラスオブジェクトのインスタンスを立ち上げたら、親クラスもロードされる
        AA aa2 = new AA();
        System.out.println(Cat.n1);
    }
}
class Cat {
    public static int n1 = 999;
    //静的コードブロック
    static {
        System.out.println("Catの静的コードブロック1が実行された。。。");
    }
}

class BB {
    //静的コードブロック
    static {
        System.out.println("BBの静的コードブロック1が実行された。。。");
    }

}

class AA extends BB {
    //静的コードブロック
    static {
        System.out.println("AAの静的コードブロック1が実行された。。。");
    }

}
