package com.hspedu.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args) {

        Map hashMap = new HashMap();

        hashMap.put(1, new Employee("jack", 30000, 1));
        hashMap.put(2, new Employee("tom", 1000, 2));
        hashMap.put(3, new Employee("jack", 12000, 3));

        Set set = hashMap.keySet();
        for (Object key : set) {
            Employee emp = (Employee) hashMap.get(key);
            if(emp.getSal() > 18000) {
                System.out.println(emp);
            }
        }
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            Employee employee = (Employee) entry.getValue();
            System.out.println(employee);

        }


    }
}
class Employee {
    private String name;
    private double sal;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
