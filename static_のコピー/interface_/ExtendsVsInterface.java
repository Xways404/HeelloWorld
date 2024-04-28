package com.hspedu.static_.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey goku = new LittleMonkey("goku");
        goku.climbing();
        goku.swimming();
        goku.fly();
    }
}
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }
    public void climbing() {
        System.out.println(name + "Monkey climbing");
    }

    public String getName() {
        return name;
    }
}
interface Fishable {
    void swimming();
}
interface brid {
    void fly();
}
class LittleMonkey extends Monkey implements Fishable, brid {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "練習に通じて魚のように泳げる");
    }

    @Override
    public void fly() {
        System.out.println(getName() + "練習に通じてbirdのようにfly");
    }
}
