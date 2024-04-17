package com.hspedu.encap;
// カプセル化のデモンストレーション
public class Encapsulation01 {
    public static void main(String[] args) {
        // Personクラスのインスタンスを生成して利用する
        Person person = new Person();
        // 名前、年齢、給与を設定する
        person.setName("田口田中上田上飯田");
        person.setAge(300);
        person.setSalary(30000);
        // 情報を表示する
        System.out.println(person.info());
        // パラメータ付きのコンストラクタを使用してインスタンスを生成する
        Person smith = new Person("smith", 2000, 50000);
        // スミスの情報を表示する
        System.out.println("========Smith's info======");
        System.out.println(smith.info());

    }
}
// Personクラス
class Person {
    // フィールド
    public String name;
    private int age;
    private double salary;

    //コンストラクタ
    public Person() {

    }
    //コンストラクタを三つ構成
    // パラメータ付きのコンストラクタ
    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        //setメソッドをコンストラクタに書き込んでも、認証可能

        // フィールドをセット
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    // 名前の取得
    public String getName() {
        return name;
    }

    // 名前の設定
    public void setName(String name) {
        //文字列の長さを制限をする
        if(name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("名前の文字数が限度を超えた、2から6文字内で、デフォルト名");
            this.name = "名なし";
        }

    }

    // 年齢の取得
    public int getAge() {
        return age;
    }

    // 年齢の設定
    public void setAge(int age) {
        // 年齢の妥当性チェック
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("年齢は１から１２０までとなる,ディフォルト値１８");
            this.age = 18;
        }
    }

    // 給与の取得
    public double getSalary() {
        return salary;
    }

    // 給与の設定
    public void setSalary(double salary) {
        //現在オブジェクトに対して権限判断を追加することができる
        this.salary = salary;
    }


    public String info() {
        return "データは、Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}
