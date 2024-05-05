package com.hspedu.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HashSetExercise {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();

        hashSet.add(new Employee("millan", 18));
        hashSet.add(new Employee("smith", 28));
        hashSet.add(new Employee("millan", 18));

        //hashcodeの値がそれぞればので、全部添加できる
        System.out.println(hashSet);
        //もし名前の年齢が等しいであれば、同一のhashcodeの値で戻す






    }
}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //もし名前の年齢が等しいであれば、同一のhashcodeの値で戻す


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
