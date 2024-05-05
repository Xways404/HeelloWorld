package com.hspedu.set_;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class LinkedHashSetSource {
    public static void main(String[] args) {
        //LinkedHashSetのソースコードの仕組み
        Set set = new LinkedHashSet();

        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("jack",1001));
        set.add(123);
        set.add("ASD");

        System.out.println(set);
        //LinkedHashSet要素の添加と取得の順が一致
        //LinkedHashSetの底のメンテナンスはLinkedHashMap（HashMapの子クラス）
        //LinkedHashSet基底のストラクチャは（配列と双方向リンクリスト）
        //一回目追加をするとき　配列テーブルを一気に16まで拡張、
        //配列は　HashMap $Node[]　保存されてるデータは　LinkedHash$Entry型



    }
}
class Customer {
    private String name;
    private int ID;

    public Customer(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }
}
