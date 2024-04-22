package com.hspedu.extend_.exercise;

public class PC extends Computer {
    private String brand;

    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void printInfo() {
        System.out.println("PC info =");
//        System.out.println(getCpu() + " " + getMemory() + " " + getDisk() + " " + getBrand());
        System.out.println(getDetails() + ", brand = " + brand);
    }
}
