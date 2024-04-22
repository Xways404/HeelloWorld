package com.hspedu.poly_.polyparameter;

public class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }
    public void work() {
        System.out.println("一般ワーカー " + getName() + " is working");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }

}
