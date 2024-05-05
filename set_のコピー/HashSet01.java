package com.hspedu.set_;

import java.util.HashSet;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HashSet01 {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        //addメソッドを実行した後には、Booleanの戻り値がある
        //追加できたらT、じゃないとF
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(1));//F
        System.out.println(set.add(4));
        System.out.println(set.add(5));

        set.remove(1);
        System.out.println(set);


        set = new HashSet();
        //HashSetは同じ元素を添加することができない
        set.add("lucy");
        set.add("lucy");//F
        //同じDogではなく、二匹の犬が名前が一緒でtomと言うから、両方立ち上げれる
        set.add(new Dog("tom"));//T
        set.add(new Dog("tom"));//T
        System.out.println(set);

        //さらに深めていくと
        //HashSetの底はHashMap
        set.add(new String("hsp"));//T
//        set add(new String("hsp"));//F

    }
}
class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
