package com.hspedu.customgeneric;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class CustomGeneric {
    public static void main(String[] args) {


    }
}
//Tigerの後はジェネリクス、だからTigerをカスタムジェネリクスクラスとして定義
//型パラメータ名<T, R, M>
//ジェネリクス配列は初期化して使えない T[] ts = new T[8];
class Tiger<T, R, M> {
    String name;
    R r;
    M m;
    T t;


    public Tiger(String name, R r, M m, T t) {
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
