package cao.hspedu.system_;

import java.util.Arrays;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class System_ {
    public static void main(String[] args) {

        System.out.println("ok1");
        //exitでプログラムを終了させる
//        System.exit(0);
        System.out.println("ok2");

        int[] src={1,2,3,4,5};
        int[] dest = new int[5];
        System.arraycopy(src, 0, dest, 0, 5);

        System.out.println("dest = " + Arrays.toString(dest));


    }
}
