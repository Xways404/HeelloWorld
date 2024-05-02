package cao.hspedu.arrays_;

import java.util.Arrays;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ArraysMethod02 {
    public static void main(String[] args) {

        Integer[] arr = {1, 2, 54, 76, 876};
        //binarySearch 二分探索
        //検索対象をソートして置く必要がある
        //含まなければ、 (-(挿入位置) - 1) を返す
        int index = Arrays.binarySearch(arr, 1);
        System.out.println(index);

        //copyOf
        //配列をまるまるコピーして新しい配列を作成する
        //+1 は配列の後にnullを差し込む
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr));

        //fill
        //配列のすべての要素を指定した値で埋める
        Integer[] num = new Integer[]{7, 12, 132};
        Arrays.fill(num, 99);
        System.out.println(Arrays.toString(num));

        //equals
        //配列の値が完全位置するかどうか
        Integer[] arr2 = {1, 3, 2, 543, 212};
        boolean equals = Arrays.equals(arr, arr2);
        System.out.println(equals);

        //asList
        //引数で指定した配列をリストとして返す
        List asList = Arrays.asList(2,3,4,5,6,7);
        System.out.println(asList);



    }
}
