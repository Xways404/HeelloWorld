package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("田中");
        list.add("村田");
        //void add(int index, Object ele):インデックスでele要素を挿入
        //index = 1にオブジェクトを一つ挿入
        list.add(1, "柴田");
        System.out.println(list);
        //boolean addAll(int index, Collection eles)：インデックスの位置からelesの全要素添加
        List list1 = new ArrayList();
        list1.add("jack");
        list1.add("tom");
        list.addAll(1,list1);
        System.out.println(list);
        //int indexOf(Object obj):ojbがコレクションで初めて出現して位置を表示
        System.out.println(list.indexOf("jack"));
        //int lastIndexOf(Object obj):ojbがコレクションで最後に出現された位置を表示
        list.add("tom");
        System.out.println(list.lastIndexOf("tom"));
        //Object remove(int index):してされたインデックス要素を削除,要素を指定して削除可能
        list.remove(0);
        System.out.println(list);
        //Object set(in index, Object ele):インデックスを指定して、その位置の要素を交換可能
        list.set(1,"marry");
        System.out.println(list);
        //List subList(int forIndex, int toIndex):fromIndex-toIndexの子コラクションが表示される
        // fromIndex <= subList < toIndex
        List returnList = list.subList(0, 3);
        System.out.println(returnList);


    }
}
