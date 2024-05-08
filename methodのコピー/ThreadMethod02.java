package com.hshedu.method;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        t2.start();

        for (int i = 0; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("main DDDDD eat mannnn  " + i);
            if(i == 5) {
                System.out.println("son eat1,, main eat22");

                //実行中のスレッドが終了するまで待機する
                t2.join();//先にt2に実行させてやる

                //現在実行しているスレッドを一時的に休止し、他のスレッドに実行機会を与える
                //Thread.yield();

                System.out.println("main eat11, son eat22");
            }
        }


    }
}

class T2 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("son JJJJJ eat mannnn  " + i);
        }
    }
}
