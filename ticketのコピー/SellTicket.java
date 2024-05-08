package com.hshedu.ticket;

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

        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();

    }
}
class SellTicket01 extends Thread {
    //マルチスレッドだからstaticで、多数のスレッド共有させる
    private static int ticketNum = 100;

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