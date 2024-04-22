package com.hspedu.encap;

// アカウントクラス
public class Account {
    //　カプセル化にするため、属性をprivateに設置する
    private String name;
    private double balance;
    private String password;

    //　コンストラクタを二つ提供

    // アカウントクラス
    public Account() {
    }
    // パラメータ付きのコンストラクタ
    public Account(String name, double balance, String password) {
        // 属性を設定
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }
    // 名前の取得
    public String getName() {
        return name;
    }

    // 名前の文字数を制限する（2から4文字まで）
    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("名前の文字数は2から4文字まで、デフォルト値「無名野郎」");
            this.name = "無名野郎";
        }
    }
    // 残高の取得
    public double getBalance() {
        return balance;
    }

    // 残高は20以上に設定する
    public void setBalance(double balance) {
        if(balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("残高不足、デフォルト値「0」");
            this.balance = 0;
        }
    }
    // パスワードの取得
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("パスワード6位にして、デフォルトパスワ「000000」");
            this.password = "000000";
        }
    }
    // アカウント情報を表示するメソッド
    public void showInfo() {
        System.out.println("アカウント情報　name = " + name + " balance = " + balance + " password = " + password);
    }
}
