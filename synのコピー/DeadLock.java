package com.hshedu.syn;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class DeadLock {
    public static void main(String[] args) {

        //デッドロックを模擬る
        DeadLockDemo a = new DeadLockDemo(true);
        DeadLockDemo b = new DeadLockDemo(false);
        a.start();
        b.start();

    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        //以下の業務ロジック分析
        //もしflagがTであれば、o1のオブジェクトロックをゲット、o2を取得してみる
        //o2を取得できなかったら、ブロックされる
        //もしflagがFであれば、o2のオブジェクトロックをゲット、o1を取得してみる
        //o1を取得できなかったら、ブロックされる
        if (flag) {
            synchronized (o1) {//オブジェクト排他制御、以下は同期コード
                System.out.println(Thread.currentThread().getName() + "go to 1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "go to 2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "go to 3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "go to 4");
                }
            }
        }
    }
}
