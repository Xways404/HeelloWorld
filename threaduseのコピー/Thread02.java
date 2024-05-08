package com.hshedu.threaduse;

/**
 * @author Li Mi~
 * @version 1.0
 * インターフェースRunnableを実現することによってスレッドを開発
 */
public class Thread02 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        //dog.start(); 呼び出せない

        //DogオブジェクトがRunnableを実現している、Threatに入れ込んで
        //そっからstartメソッドをコールする
        Thread thread = new Thread(dog);
        thread.start();
        //or new Thread(dog).start();


    }
}
class Dog implements Runnable {

    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("nimamazaixiao" + (++count) + Thread.currentThread().getName());
            //休止1秒
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
