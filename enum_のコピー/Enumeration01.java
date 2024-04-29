package com.hspedu.enum_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);

    }
}
class Season {
    private String name;
    private String desc;

    public static final Season SPRING = new Season("Spring", "warm");
    public static final Season SUMMER = new Season("Summer", "Hot");
    public static final Season AUTUMN = new Season("Autumn", "Coolness");
    public static final Season WINTER = new Season("Winter", "Cold");

    //コンストラクターを私有化にして、newされるのを防止する
    //setメソッドを削除し、書き直されることを防ぐ
    //Seasonの内部に、固定なオブジェクトを作成する
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
