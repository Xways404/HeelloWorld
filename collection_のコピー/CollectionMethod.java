package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        // add: 単一の要素を追加
        list.add("jack");
        list.add(10);// list.add(new Integer(10))
        list.add(true);
        System.out.println(list);
        //remove: してされた要素を削除
        list.remove(0);
        System.out.println(list);
        //contains: 要素が存在するかチェック
        System.out.println(list.contains("jack"));
        //size: 要素の個数を獲得する
        System.out.println(list.size());
        //isEmpty: 空であるか判断
        System.out.println(list.isEmpty());
        //clear: 全て削除
        list.clear();
        System.out.println(list);
        //addAll: 多数配列作成
        ArrayList list1 = new ArrayList();
        list1.add("君の名は");
        list1.add("三国志");
        list.addAll(list1);
        System.out.println(list1);
        //containsAll: 多元素の存在をチェック
        System.out.println(list.containsAll(list1));
        //removeAll 多元素を削除
        list.removeAll(list1);
        System.out.println(list);
    }
}
