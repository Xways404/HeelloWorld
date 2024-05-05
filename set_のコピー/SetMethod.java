package com.hspedu.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class SetMethod {
    public static void main(String[] args) {
        //setインターフェースの実現クラスHashSet　
        //要素の重複が不可
        //nullは追加でけるけど、一つのみになる
        //順なしである、要は　追加順と取得順が不一致である
        //取得順が固定的である

        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);//重複
        set.add(null);
        set.add(null);//二度目のから
        for(int i = 0; i < 3; i++) {
            System.out.println(set);
        }

        //走査
        //イテレータが使用できる
        //
        Iterator iterator = set.iterator();
        System.out.println("-----------イテレータ---------");
        while(iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }
        //拡張forループで走査できる
        System.out.println("-----------拡張forループ---------");
        for(Object object : set) {
            System.out.println(object);
        }

        //setメソッドはインデックスで獲得できない


    }
}
