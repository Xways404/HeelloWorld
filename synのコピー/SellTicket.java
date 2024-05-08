package com.hshedu.syn;

/**
 * @author Li Mi~
 * @version 1.0
 * マルチスレッドでチケットセールウィンドを３つ模擬
 */
public class SellTicket {
    public static void main(String[] args) {

//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
        //結果的に売りすぎて１００以上超えてマイナスが出た
        //t1が先にチケットが０になったと探知できたとしても、t2t3もすぐ入ってしまうので売りすぎ現象になる

//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();

        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();


    }
}
//インターフェース方式を実現する、synchronizedを使用してスレッド同期を実現
class SellTicket03 extends Thread {
    //マルチスレッドだからstaticで、多数のスレッド共有させる
    private int ticketNum = 100;
    private boolean loop = true;

    private synchronized void sell() {//同期メソッド、synchronized同時に単一のスレッドにしかrunメソッドを操作させない
        if (ticketNum <= 0) {
            System.out.println("Done");
            loop = false;
            return;
        }
        //50ms休止する
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Window " + Thread.currentThread().getName() + " 一枚売った"
                + " 残りチケット数＝　" + (--ticketNum));
    }



    @Override
    public void run() {//同期メソッド、同時に単一のスレッドにしかrunメソッドを操作させない
        while (loop) {
            sell();
        }
    }
}
class SellTicket02 implements Runnable {
    //マルチスレッドだからstaticで、多数のスレッド共有させる
    private int ticketNum = 100;


    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("Done");
                break;
            }
            //50ms休止する
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Window " + Thread.currentThread().getName() + " 一枚売った"
                    + " 残りチケット数＝　" + (--ticketNum));
        }

    }
}