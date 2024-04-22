package com.hspedu.homework.homework05;

public class HomeWork05 {
    public static void main(String[] args) {
        Worker jack = new Worker("jack", 10000);
        jack.setSalMonth(15);
        jack.printSal();

        Peasant smith = new Peasant("smith", 20000);
        smith.printSal();

        Teacher teacher = new Teacher("順平", 2000);
        teacher.setClassDays(360);
        teacher.setClassSal(5000);
        teacher.printSal();

        Scientist scientist = new Scientist("キリト", 20000);
        scientist.setBonus(1);
        scientist.printSal();

    }
}
