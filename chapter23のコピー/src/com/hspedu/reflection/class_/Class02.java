package com.hspedu.reflection.class_;

import com.hspedu.Car;

import java.lang.reflect.Field;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String classAllPath = "com.hspedu.Car";
        //Carクラスに応じるClassオブジェクト
        //<?>特定ができないjava型
        Class cls = Class.forName(classAllPath);
        //cls出力
        System.out.println(cls);//clsオブジェクトを表示、
        System.out.println(cls.getClass());
        System.out.println(cls.getPackage().getName());
        System.out.println(cls.getName());
        Car car = (Car) cls.newInstance();
        System.out.println(car);
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        brand.set(car, "benz");
        System.out.println(brand.get(car));
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }


    }
}
