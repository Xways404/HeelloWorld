package com.hspedu.exception;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        // 1. num1 / num2 = > 10 / 0
        // 2. num2 = 0のため、プログラミングが例外をスローする,ArithmeticException
        // 3. 例外がスローされたら、プログラミングが退出し、以下のコードが実行されなくなる
        // 4. 致命的な問題じゃないのに、全プログラミングが実行することができないのはよくない
        // 5。 例外処理を行う
//        int res = num1 / num2;
        //もし異常や問題が発生しそうと感じたら、try-catchの例外処理で解決

        try {
            int res = num1 / num2;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage()) ;
        }

        System.out.println("programing.....");
    }
}

