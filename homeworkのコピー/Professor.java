package com.hspedu.homework;

public class Professor extends Teacher {
    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println("教授のデータ");
        super.introduce();
    }
}
