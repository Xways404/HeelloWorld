package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class List_ {
    public static void main(String[] args) {
        //Listコレクションクラスでは要素順番がありで（追加と取得の順が同じ）、重複が可能
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);//1が二つ存在していると思われる、重複
        System.out.println(list);
        //Listコレクションの中では各要素がそれ応じたインデックスが存在
        //インデックスは０から
        System.out.println(list.get(3));
    }
}
