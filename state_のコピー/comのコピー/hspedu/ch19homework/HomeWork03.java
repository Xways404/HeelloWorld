package com.hspedu.ch19homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) throws IOException {

        String filePath  = "src/dog.propertise";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        properties.list(System.out);

        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");

        Dog dog = new Dog(name, age);
        System.out.println(dog);
    }
}
class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
