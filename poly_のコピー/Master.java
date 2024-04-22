package com.hspedu.poly_;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 「animal」のコンパイル時の型はAnimalであり、Animalの子クラスのオブジェクトを指す（受け入れる）ことができる。
    public void feed(Animal animal, Food food) {
        System.out.println("主人 " + name + " が　" + animal.getName() + " に " + food.getName());
    }
//    // 主人が犬に骨を与える
//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人 " + name + " が　" + dog.getName() + " に " + bone.getName());
//    }
//    public void feed(Cat cat, Fish fish) {
//        System.out.println("主人 " + name + " が　" + cat.getName() + " に " + fish.getName());
//    }
}
