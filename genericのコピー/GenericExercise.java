package com.hspedu.generic;

import java.util.*;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class GenericExercise {
    public static void main(String[] args) {

        //ジェネリクスでHashSetに三つの学生オブジェクトを入れ込む
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 19));
        students.add(new Student("king", 18));

        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getAge());
        }

        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put("jack", new Student("jack", 18));
        hashMap.put("tom", new Student("tom", 19));
        hashMap.put("king", new Student("king", 18));

        //iterator EntrySet
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());

                                                                }


    }
}
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

