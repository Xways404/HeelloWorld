package com.hspedu.generic;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Generic03 {
    public static void main(String[] args) {

        Person<String> person = new Person<String>("caonima");

        Person<Integer> person1 = new Person<Integer>(54321);



    }
}
class Person<E> {
    E s; //Eはsのデータ型を表示し、Personオブジェクトの時に指定して、コンパイルする際にもすでにEの型を確定した

    public Person(E s) {//コンストラクタでも使用可能
        this.s = s;
    }

    public E f() {//getterでも使用可能
        return s;
    }
}
