package com.hspedu.c14homework;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        Car bmw = new Car("BMW", 400000);
        Car bently = new Car("Bently", 5000000);

        arrayList.add(bmw);
        arrayList.add(bently);
        arrayList.remove(bmw);
        arrayList.contains(bmw);
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
//        System.out.println(arrayList.clear());
        arrayList.addAll(arrayList);
        System.out.println(arrayList);
        arrayList.containsAll(arrayList);
//        arrayList.removeAll(arrayList);

        for(Object o : arrayList){
            System.out.println(o);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }


    }
}
class Car {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
