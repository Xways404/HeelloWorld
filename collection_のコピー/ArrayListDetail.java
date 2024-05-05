package com.hspedu.collection_;

import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ArrayListDetail {
    public static void main(String[] args) {
        //スレッドセーフティがない、ソースコードから見ればkeywordがないから
        //マルチスレッドの場合は、ArrayListが不安全
        ArrayList list = new ArrayList();
        list.add("1");
        list.add(null);
        list.add("2");
        list.add(null);
        //

    }
}
