package com.hspedu.list_;

import java.util.*;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ListExercise2 {
    public static void main(String[] args) {

//        List list = new ArrayList();
//        List list = new Vector();
        List list = new LinkedList();

        list.add(new Book("君の名は", 4360, "荒海"));
        list.add(new Book("膵臓を食べたい", 2340, "酢ブダ"));
        list.add(new Book("三国志", 5600, "網羅寒中"));

        //コレクションでどうやって順番並び
        //sortランク


        //イテレータでループ
        System.out.println("---------Iterator------------");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        sort(list);
        System.out.println("---------List------------");
        for(Object o : list) {
            System.out.println(o);
        }




    }
    //静的メソッド
    public static void sort(List list) {

        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if(book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}
class Book {
    private String name;
    private int price;
    private String author;

    public Book(String name, int price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}