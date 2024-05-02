package cao.hspedu.bignum;

import java.math.BigInteger;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class BigInteger_ {
    public static void main(String[] args) {

        //非常に大きい数字を処理する必要がある際に、longが足りなくなる
        //BigIntegerクラスを利用
//        long l =654321234567865432;
//        System.out.println(l);
        BigInteger b = new BigInteger("876543212345678987654");
        BigInteger b2 = new BigInteger("100");
        System.out.println(b);
        //BigIntegerを演算する際に、それに応じたメソッドを使わなければならない
        //+
        BigInteger add = b.add(b2);
        System.out.println(add);
        //-
        BigInteger subtract = b.subtract(b2);
        System.out.println(subtract);
        //*
        BigInteger multiply = b.multiply(b2);
        System.out.println(multiply);
        ///
        BigInteger divide = b.divide(b2);
        System.out.println(divide);

    }
}
