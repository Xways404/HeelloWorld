package com.hspedu.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Object object = new Cat();

        animal.eat(); //実際に運行するときに子クラスから探し始める
//        animal.catchMouse();
        animal.sleep();
        animal.run();
        animal.show();

        Cat cat = (Cat) animal;
        cat.catchMouse();



    }
}
