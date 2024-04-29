package com.hspedu.enum_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class EnumsExercise02 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for (Week week : weeks) {
            System.out.println(week);
        }
    }
}
enum Week{
    //Weekの列挙型オブジェクトを定義
    MONDAY("monday"), TUESDAY("tuesday"), WEDNESDAY("wednesday"), THURSDAY("thursday"),
    FRIDAY("friday"), SATURDAY("saturday"), SUNDAY("sunday");
    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
