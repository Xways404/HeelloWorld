package com.hspedu.homework.homework05;

public class Teacher extends Employee{
    private int classDays;
    private double classSal;

    public Teacher(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void printSal() {
        System.out.println("先生 ");
        System.out.println(getName() + "　年俸は= "
                + (getSal() * getSalMonth() + classDays * classSal));
    }

    public int getClassDays() {
        return classDays;
    }

    public void setClassDays(int classDays) {
        this.classDays = classDays;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }
}
