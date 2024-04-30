package com.hspedu.exception;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class CustomException {
    public static void main(String[] args) {
        int age = 80;
        if(!(age >= 18 && age <= 120)) {
            throw new AgeException("age between 18-120");
        }
        System.out.println("the date is right");
    }
}
//一般的に例外をカスタムする場合は、RuntimeExceptionを継承する

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}

