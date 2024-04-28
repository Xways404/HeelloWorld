package com.hspedu.static_;

public class ChildGame {
    public static void main(String[] args) {
        //ガキがどれぐらい来ていつかを統計する
        int count = 0;

        Child child1 = new Child("たけし");
        child1.join();
        child1.count++;

        Child child2 = new Child("まさき");
        child2.join();
        child2.count++;

        Child child3 = new Child("せいた");
        child3.join();
        child3.count++;
        System.out.println(Child.count);
    }
}
class Child {
    private String name;
    //静的変数で、クラスの全てのオブジェクトに共有する
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }
    public void join() {
        System.out.println(name + " ゲームに参加...");
    }
}