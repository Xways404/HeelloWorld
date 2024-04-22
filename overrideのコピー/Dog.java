package com.hspedu.override;

public class Dog {
    //DogはAnimalの子クラスであるため
    //DogのcryメソッドとAnimalのcryメソッドの定義形式が同様であるため
    //DogのcryメソッドがAnimalのcryメソッドをオーバーライドしたと言える
    public void cry() {
        System.out.println("Dog cry");
    }
}
