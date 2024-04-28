package com.hspedu.static_.final_;

public class FinalDetail01 {
    public static void main(String[] args) {

    }
}
class AA {
    public final double TAX_RATE = 0.08;
    //値を最初に与えないといかん
    public final double TAX_RATE1;
    public final double TAX_RATE2;

    public AA() {
//        コンストラクタで与えれたいける
        TAX_RATE1 = 1.1;
    }
    {
//        コードブロックでも与えられる
        TAX_RATE2 = 8.2;
    }
}
