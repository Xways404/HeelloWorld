package com.hspedu.set_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HashSetStructure {
    public static void main(String[] args) {

        //HashSetの底はHashMap
        //配列を作成、配列の型は　Node[]
        //Node[]をtableテーブルとして名付ける
        Node[] table = new Node[16];
        System.out.println(table);
        //Nodeを作成
        Node john = new Node("john", null);

        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;//jackノードをjohnに繋げる
        Node rose = new Node("rose", null);
        jack.next = rose;//

        System.out.println(table);


    }
}
class Node { //ノード、データ保存、次のノードの指し、リンクリストを形成
    Object item; //データ保存
    Node next; //次のノードに繋げる

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
