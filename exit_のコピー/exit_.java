package com.hshedu.exit_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class exit_ {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        //スレッドを終了してほしいなら、loop変数を書き換えればいい、
        //t1にrunメソッドから退出して、ついてにt1スレッドを終了させる

        //mainスレッドに十秒休止させてから退出
        Thread.sleep(10 * 1000);
        t1.setLoop(false);

    }
}
class T extends Thread {

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println("ASfdghfjgdsa");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("NOW");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
