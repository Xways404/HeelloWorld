package com.hspedu.c14homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {

        Map m = new HashMap();
        m.put("jack", 650);//int to Integer
        m.put("tom", 1200);//int to Integer
        m.put("smith", 2900);//int to Integer

        System.out.println(m);

        m.put("jack", 2600);
        System.out.println(m);

        //keySet 走査
        Set keySet = m.keySet();
        for(Object key : keySet){
            m.put(key, (Integer)m.get(key) + 100);
        }
        System.out.println(m);

        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for(Object val : m.values()){
            System.out.println(val);
        }

    }
}