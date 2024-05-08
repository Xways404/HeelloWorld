package com.hshedu.threaduse;

/**
 * @author Li Mi~
 * @version 1.0
 * mainスレッドで２つの子スレッドを起動する
 */
public class Thread03 {
    public static void main(String[] args) {

        T1 t1 = new T1();
        T2 t2 = new T2();

        new Thread(t1).start();
        new Thread(t2).start();

    }
}

class T1 implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello mf" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }

    }
}
class T2 implements Runnable {

    @Override
    public void run() {
        int count = 0;

        while (true) {
            System.out.println("SDFGHJ mf" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }

    }
}
