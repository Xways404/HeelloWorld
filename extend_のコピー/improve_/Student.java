package com.hspedu.extend_.improve_;
// 親クラスとして立ち上げ、Pupil and Graduate
public class Student {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }
    public void showInfo() {
        System.out.println("名前：" + name + "　年齢：" + age + "　成績：" + score);
    }
}
