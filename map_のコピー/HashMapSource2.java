package com.hspedu.map_;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HashMapSource2 {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        for(int i = 1; i <= 12; i++) {
            hashMap.put(new A(i), "hello");
        }
        System.out.println(hashMap);


    }
}
class A {
    private int num;

    public A(int num) {
        this.num = num;
    }
    //全てのAオブジェクトのHashcodeの値が等しくする　100
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "≠\nA{" +
                "num=" + num +
                '}';
    }
}
