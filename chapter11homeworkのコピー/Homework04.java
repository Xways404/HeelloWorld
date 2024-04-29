package com.hspedu.homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,8);
    }
}
interface ICalculate {
    public double work(double n1, double n2);
}
class Cellphone {
    public void testWork(ICalculate cal, double n1 ,double n2) {
        double result = cal.work(n1, n2);
        System.out.println("result = " + result);
    }
}
