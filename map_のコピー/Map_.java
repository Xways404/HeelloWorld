package com.hspedu.map_;

import java.util.HashMap;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Map_ {
    public static void main(String[] args) {
        //
        //
        //
        //
        HashMap hashMap = new HashMap();
        hashMap.put("A", 1);//k-v
        hashMap.put("B", 2);
        hashMap.put("A", 3);//kが同じであれば、入れ替え
        hashMap.put("D", 4);
        hashMap.put("E", 4);//vが同じでも問題ない
        hashMap.put(null, null);
        hashMap.put(null, "ca");
        System.out.println(hashMap);
    }
}
