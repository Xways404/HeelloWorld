package com.hspedu.map_;

import java.util.Hashtable;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HashTableExercise {
    public static void main(String[] args) {

        Hashtable table = new Hashtable();

        table.put("john", 100);
        //table.put(null, 100);//例外NullPointException
        //table.put("john", null);//例外NullPointException
        table.put("lucy", 100);
        table.put("lic", 100);
        table.put("lic", 88);
        System.out.println(table);

        //基底は配列である　型は、Hashtable$Entry[](内部クラスである)初期化の大きさは11
        //threshold 8 = 11 * 0.75(ロードファクター)拡張だね
        //拡張は拡張スクラクチャで進行される
        //

    }
}
