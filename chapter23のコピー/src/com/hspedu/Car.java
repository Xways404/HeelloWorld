package com.hspedu;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Car {
    public String brand = "wdcfd";
    public int price = 54321234;
    public String color = "BB";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
