package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国志", "田中", 10.1));
        col.add(new Book("岐阜県", "宮城", 5.1));
        col.add(new Book("愛知県", "未織田", 34.6));

//        System.out.println(col);
        //colコレクションを走査する
        //colのイテレータを得る
        Iterator iterator = col.iterator();
        //whileループで走査する
        while (iterator.hasNext()) {//データがまだあるかを判断する
            //戻し要素は、Object型である
            Object obj = iterator.next();
            System.out.println(obj);

        }
        //whileループが終了後、この時にイテレータは最後の要素を指しているため
        //NoSuchElementException　例外発生
        //iterator.next();例外発生
        //もし再度操作したけりゃ、イテレータをリセットしなければならない
        iterator = col.iterator();
        System.out.println("==========");
        while (iterator.hasNext()) {//リセットしてから新規ループ
            Object obj =  iterator.next();
            System.out.println(obj);
        }

    }
}
class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
