package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国志", "田中", 10.1));
        col.add(new Book("岐阜県", "宮城", 5.1));
        col.add(new Book("愛知県", "未織田", 34.6));

        //拡張for文、コレクションで使用可能
        //拡張forは、イテレータである

        for (Object book : col) {
            System.out.println(book);
        }
        //拡張for文は配列でも使用可能
        int[] nums = {1, 3, 45532, 6};
        for(int i : nums) {
            System.out.println(i);
        }

    }
}
