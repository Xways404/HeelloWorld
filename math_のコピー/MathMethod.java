package cao.hspedu.math_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class MathMethod {
    public static void main(String[] args) {

        //Mathのよく使われるメソッド（静的メソッド）

        // abs 絶対値
        int abs = Math.abs(-10);
        System.out.println(abs);

        //pow　累乗
        double pow = Math.pow(2, 4);
        System.out.println(pow);

        //ceil 切り上げ　
        double ceil = Math.ceil(3.5);
        System.out.println(ceil);

        //floor　切り捨て
        double floor = Math.floor(3.5);
        System.out.println(floor);

        //round　四捨五入
        double round = Math.round(3.5);
        System.out.println(round);

        //sqrt 平方根
        double sqrt = Math.sqrt(400);
        System.out.println(sqrt);

        //random 乱数
        //0 以上 1 未満 (0 は含むが、 1 は含まない) の範囲で浮動小数点の擬似乱数を返す
        //a-b の間の整数を戻す　(int)(a + Math.random() * (b - a + 1))
        for(int i = 0; i < 10; i++) {
            System.out.println((int)(2 + Math.random() * (7 - 2 +1)));
        }

        //min max　最小値　最大値
        int min = Math.min(1, 9);
        System.out.println(min);
        int max = Math.max(1, 9);
        System.out.println(max);
    }
}
