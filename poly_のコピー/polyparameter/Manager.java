package com.hspedu.poly_.polyparameter;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bones) {
        super(name, salary);
        this.bonus = bones;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void manage() {
        System.out.println("マネジャ　" + getName() + " is managing money");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
