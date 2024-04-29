package com.hspedu.homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework08 {
    public static void main(String[] args) {

        Color green = Color.GREEN;
        green.show();
         switch (green) {
             case RED:
                 System.out.println("red");
                 break;
             case YELLOW:
                 System.out.println("yellow");
                 break;
             case BLUE:
                 System.out.println("blue");
                 break;
             case GREEN:
                 System.out.println("green");
                 break;
             case BLACK:
                 System.out.println("black");
                 break;
             default:
                 System.out.println("nothing");
         }
    }
}
interface IMYInterface {
    public void show();
}
enum Color implements IMYInterface {
    RED(255, 0, 0), BLUE(0, 0, 255), BLACK(0, 0, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(redValue + " " + greenValue + " " + blueValue);
    }
}
