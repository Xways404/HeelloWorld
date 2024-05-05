package com.hspedu.list_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class LinkedList01 {
    public static void main(String[] args) {
        //双方向リンクリスト

        Node jack = new Node("jack");
        Node queen = new Node("queen");
        Node king = new Node("king");

        //データを繋げ、双方向リンクリストをけいせい
        // jack -> queen -> king
        jack.next = queen;
        queen.next = king;
        // king -> queen -> jack
        king.pre = queen;
        queen.pre = jack;

        Node first = jack;//jackをfirstとして設定
        Node last = king;//kingをlastとして設定

        //ヘッドからテールまで走査
        while (true) {
            if (first == null) {
                break;
            }
            //ヘッドのデータを出力
            System.out.println(first);
            first = first.next;
        }

        //データを双方向リンクリストに挿入、指向を変更する
        Node kitty = new Node("kitty");
        kitty.next = king;
        kitty.pre = queen;
        king.pre = kitty;
        queen.next = kitty;

        //再度ヘッドから走査するためには、first = jack;
        System.out.println("-------2nd-------");
        first = jack;
        while (true) {
            if (first == null) {
                break;
            }
            //ヘッドのデータを出力
            System.out.println(first);
            first = first.next;
        }
        last = king;
        while (true) {
            if (last == null) {
                break;
            }
            //ヘッドのデータを出力
            System.out.println(first);
            last = last.pre;
        }



    }
}
class Node {
    public Object item;//データを保存すること
    public Node next;//次の節点を指す
    public Node pre;//前の節点を指す
    public Node(Object name) {
        this.item = name;
    }
    public String toString() {
        return "Node name = "  + item;
    }
}
