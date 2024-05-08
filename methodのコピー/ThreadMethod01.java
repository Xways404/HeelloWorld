package com.hshedu.method;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {

        //関連メソッドをテスティング
        T t = new T();
        t.setName("t1");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();//子メソッドを起動

        //mainメソッドにhiを5回プリントアウトしてもらってから、メソッドを休止させる
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }
        System.out.println(t.getName() + " スレッドの優先順位＝　"  + t.getPriority());
        t.interrupt();

    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                //Thread.currentThread().getName() 現在進行のスレッド名を獲得する
                System.out.println(Thread.currentThread().getName() + " 肉まん食べる・・・・・" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休止中￥￥￥￥");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //スレッドがinterruptメソッドまで実行された時点に、例外をキャッチして、そこに自分の業務コードを追加することができる
                //InterruptedException　中止じゃなくて、中断例外をキャッチ
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
