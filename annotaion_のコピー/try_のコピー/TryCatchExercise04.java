package com.hspedu.try_;

import java.util.Scanner;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class TryCatchExercise04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr = "";

        while (true) {
            System.out.println("please add a num");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("it is not a number");
            }
        }
        System.out.println(num);
    }
}

