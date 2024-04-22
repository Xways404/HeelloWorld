package com.hspedu.homework.homework05;

import com.hspedu.override.Person;

public class Peasant extends Employee {
    public Peasant(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void printSal() {
        System.out.print("農民 ");
        super.printSal();
    }
}
