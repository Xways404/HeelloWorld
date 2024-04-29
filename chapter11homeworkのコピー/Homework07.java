package com.hspedu.homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework07 {
    public static void main(String[] args) {
        Car01 car01 = new Car01(67);
        car01.getAir().flow();
        new Car01(32).getAir().flow();
        new Car01(-21).getAir().flow();
    }
}
class Car01 {
    private double temp;

    public Car01(double temp) {
        this.temp = temp;
    }

    class Air {
        public void flow() {
            if (temp >40) {
                System.out.println("temp higher than 40, air cold");
            } else if (temp < 0) {
                System.out.println("temp lower than 0, air hot");
            } else {
                System.out.println("close air");
            }
        }
    }
    public Air getAir() {
        return new Air();
    }
}


