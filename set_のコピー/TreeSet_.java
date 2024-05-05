package com.hspedu.set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class TreeSet_ {
    public static void main(String[] args) {

        //引数なしのコンストラクターで、TreeSetを立ち上げる時に、順なしのままである
        //添加された要素を文字列の大きさで並べて欲しい
        //TreeSetが提供するコンストラクタで、比較することができる（匿名インナクラス）
        //ソート処理の規則を指定する

//        TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).compareTo((String) o1);
            }
        });

                treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sb");
        treeSet.add("x");

        System.out.println(treeSet);
    }
}
