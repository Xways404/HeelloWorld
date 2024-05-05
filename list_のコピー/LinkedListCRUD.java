package com.hspedu.list_;

import java.util.LinkedList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);

        //ノードを一個削除
        linkedList.remove();
        //ヘッド削除が黙認されてる
        System.out.println(linkedList);

        for(Object o : linkedList) {
            System.out.println(o);
        }



        //この時点では、まだヘッドとテールがnullの状態である



    }
}
