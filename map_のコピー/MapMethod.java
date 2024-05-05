package com.hspedu.map_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class MapMethod {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("javk", new Book("", 100));


    }
}
class Book {
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

