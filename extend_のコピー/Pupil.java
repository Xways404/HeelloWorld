package com.hspedu.extend_;

public class Pupil {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }
    public void testing() {
        System.out.println("小学生の" + name + "は今数学のテスト中");
    }
    public void showInfo() {
        System.out.println("名前：" + name + "　年齢：" + age + "　成績：" + score);
    }
}
