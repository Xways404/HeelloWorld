package com.hspedu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu tom = new Stu("Tom");
        tom.payFee(100);
        Stu jack = new Stu("jack");
        jack.payFee(200);
        Stu.showFee();

    }
}
class Stu {

    private String name;
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    public static void payFee(double fee) {
        Stu.fee += fee;
    }
    public static void showFee() {
        System.out.println("総学費は　" + Stu.fee);
    }
}
