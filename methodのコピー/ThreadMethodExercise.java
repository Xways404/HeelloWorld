package com.hshedu.method;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {

        Thread t3 = new Thread(new T3());

        for (int i = 0; i < 10; i++) {
            System.out.println("Hiiiiii " + i);
            if (i == 5) {//mainスレッドが　hi　を５回出力された
                t3.start();//子スレッドを起動する　helloを出力
                t3.join();//例外スロー、すぐt3の子スレッドをmainスレッドに挿入する、先に実行させる


            }
        }

    }
}
class T3 implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello " + (++count));
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