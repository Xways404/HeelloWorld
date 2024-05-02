package cao.hspedu.bignum;

import java.math.BigDecimal;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("1.056789087654567897654345678");
        BigDecimal bigDecimal1 = new BigDecimal("3212.543212345");
        System.out.println(bigDecimal);

        System.out.println(bigDecimal1.add(bigDecimal));
        System.out.println(bigDecimal1.subtract(bigDecimal));
        System.out.println(bigDecimal1.multiply(bigDecimal));
        //例外発生が可能
        System.out.println(bigDecimal1.divide(bigDecimal));
        //精度限定
        System.out.println(bigDecimal1.divide(bigDecimal, BigDecimal.ROUND_CEILING));
    }
}
