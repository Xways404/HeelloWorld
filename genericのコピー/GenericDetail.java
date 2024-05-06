package com.hspedu.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class GenericDetail {
    public static void main(String[] args) {

        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        //Aで指定したから、Bを受け入れない
//        Pig<A> bPig = new Pig<A>(new B());

        //だが、BがAを継承すれば、子クラスとして受け取る
        Pig<A> bPig = new Pig<A>(new B());
        bPig.f();

        //ジェネリクスの使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        //実際の開発では、略してかくのが一般
        //コンパイルが型の推定を行うから、こっちの方がおすすめ
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();

        //ジェネリクスのデフォルトはObjectである
        //ArrayList<Object> list = new ArrayList<Object>();
        ArrayList list = new ArrayList();



    }
}
class A {}
class B extends A {}
class Pig<E> {
    E e;

    public Pig(E e) {
        this.e = e;
    }
    public void f() {
        System.out.println(e.getClass());//実行型
    }
}

