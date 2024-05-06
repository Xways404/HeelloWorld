package com.hspedu.customgeneric;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        //ジェネリクスTにUserを指定
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, 10, "jack"));
        dao.save("002", new User(2, 20, "tom"));
        dao.save("003", new User(3, 30, "marry"));
        List<User> list = dao.list();
        System.out.println(list);

    }
}

