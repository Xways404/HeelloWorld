package com.hspedu.list_;

import java.util.*;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ListFor {
    public static void main(String[] args) {

        //Listインターフェースの実現子クラス、Vector LinkedList
        List list = new ArrayList();
//        List list1 = new Vector();
//        List list2 = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator iterator = list.iterator();
        //イテレータ走査
        while(iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }
        //拡張forループ
        for(Object object : list) {
            System.out.println(object);
        }
        //愚直なforループ
        for(int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
