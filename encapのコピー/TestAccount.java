package com.hspedu.encap;

// アカウントのテストクラス
public class TestAccount {
    public static void main(String[] args) {
        // アカウントオブジェクトを作成
        Account account = new Account();

        account.setName("jack");
        account.setBalance(60);
        account.setPassword("123456");
        // アカウント情報を表示
        account.showInfo();

    }
}
