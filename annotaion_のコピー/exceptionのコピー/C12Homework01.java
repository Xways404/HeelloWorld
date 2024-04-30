package com.hspedu.exception;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class C12Homework01 {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("引数の個数が違う");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1, n2);
            System.out.println("res: " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("引数のが違う、整数を入れなさい");
        } catch (ArithmeticException e) {
            System.out.println("割る０の例外が発生");
        }
    }
    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
