package com.hspedu.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Collections_ {
    public static void main(String[] args) {

        //ArrayListコレクションを立ち上げ、テスティング用に使う
        //
        //
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");

        //reverse(List):Listの中の要素を反転
        Collections.reverse(list);
        System.out.println(list);
        //shuffle(List): Listコレクションの要素をランダムで順つけ
        Collections.shuffle(list);
        System.out.println(list);
        //sort(List): 元素と自然並びに基づいて指定し、Listコレクション要素を上る順で
        Collections.sort(list);
        System.out.println(list);
        //sort(List, Comparator): 文字列の大きさと長さで比較するとき
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(list);
        //swap(List, int, int): listコレクションでi要素とj要素を交換する
        Collections.swap(list, 0, 1);
        System.out.println(list);

        //Object max(Collection): 自然順の最大要素
        System.out.println("zirang" + Collections.max(list));
        //Object max(Collection, Comparator):
        Object maxObject = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o2).length() - ((String)o1).length();
            }
        });
        System.out.println(list);
        //Object min(Collections): 最小値
        System.out.println("zirang" + Collections.min(list));
        //Object min(Collection, Comparator):
        Object minObject = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println(list);
        //int frequency(Collection, Object): 指定されたコレクション中の要素の出現回数を戻す
        System.out.println("tom =" + Collections.frequency(list, "tom"));
        //void copy(list dest, list src): src中の内容をdestにコピーする
        ArrayList dest = new ArrayList();
        //コピーを実現するために、destをlistサイズまで拡張
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest, list);
        System.out.println("dest = " + dest);

        //boolean replaceAll(List, list, Object oldVal, Object newVal):　Listの古い値を新しい値に入れ替え
        Collections.replaceAll(list, "tom", "caonima");
        System.out.println(" changed list = " + list);



    }
}
