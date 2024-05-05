package com.hspedu.collection_;

import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ArrayListSource {
    public static void main(String[] args) {

        //引数なしコンストラクターでArrayListオブジェクトを立ち上げた
        ArrayList list = new ArrayList();
        //ArrayList list = new ArrayList(8);
        //forループでlistコレクションに１から１０の配列を添加
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        //さらに11から15までの配列を増加した
        for(int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
    }
}
