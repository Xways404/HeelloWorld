package com.hspedu;

/**
 * @author Li Mi~
 * @version 1.0
 */

import java.io.Serializable;

public class Person implements Serializable{
    public static void main(String[] args) {

    }
    public String name;
    public int age;

    public Person(String name, int age) {
        System.out.println("Create person.");
        this.name = name;
        this.age = age;
    }
}

class Student implements Serializable{
    public String name;
    public int age;

    public Student(String name, int age) {
        System.out.println("Create student.");
        this.name = name;
        this.age = age;
    }
}

class Teacher implements Serializable{
    public String name;
    public int age;

    public Student student;

    public Teacher(String name, int age, Student student) {
        System.out.println("Create teacher.");
        this.name = name;
        this.age = age;
        this.student = student;
    }
}

