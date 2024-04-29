package com.hspedu.enum_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class SuppressWarnings_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        int i;
        System.out.println(list.get(1));

    }
}

