package com.hspedu.extend_.improve_;
// 子クラス
public class Sub extends Base{
    public Sub() {
        System.out.println("sub()....");
    }
    public void sayOk() { // 子クラスのメソッド
        // プライベートのフィールド（n4）は子クラスから直接にアクセスできない
        System.out.println(n1 + " " + n2 + " " + n3);
        test100();
        test200();
        test300();
        // test400();エラー
        // 親クラスのパブリックメソッドでアクセスする
        System.out.println("n4 = " + getN4());
        callTest400();// 委託
    }
}
