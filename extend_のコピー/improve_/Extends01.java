package com.hspedu.extend_.improve_;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "明和";
        pupil.age = 1;
        pupil.testing();
        pupil.setScore(50);
        pupil.showInfo();
        System.out.println("======================");
        Graduate graduate = new Graduate();
        graduate.name = "千種";
        graduate.age = 22;
        graduate.testing();
        graduate.setScore(80);
        graduate.showInfo();
    }
}
