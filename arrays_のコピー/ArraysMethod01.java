package cao.hspedu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ArraysMethod01 {
    public static void main(String[] args) {
        Integer[] integers = {1, 21, 43};
//        for(int i = 0; i < integers.length; i++) {
//            System.out.println(integers[i]);
//        }
        System.out.println(Arrays.toString(integers));

        //sort
        Integer arr[] = {1, -1, 7, 0, 89};
        System.out.println(Arrays.toString(arr));
        //順番並び
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //カスタム順
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
