package com.hspedu.map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "jack");
        map.put("no2", "queen");
        map.put("no3", "king");

        //k-v 最終的にはHashMap$Node node = newNode(hash, key, value, null)
        //k-vはプログラマーに操作しやすいために、Entryコレクションが創建され、このコレクションで保存されてるそうそはEntry（k-v）
        //EntrySet<Entry<K, v>>
        //Map.Entryが二つの重要なメソッドが提供しているから K getKey(); V getValue;

        Set set = map.entrySet();
        System.out.println(set.getClass());//HashMap$EntrySetEntrySet
        for(Object obj : set) {
            //System.out.println(obj.getClass());
            //HashMap＄Nodeからk-vを取得するため
            //先にダウンキャストは行う
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }

    }
}
