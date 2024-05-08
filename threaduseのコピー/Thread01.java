package com.hshedu.threaduse;

/**
 * @author Li Mi~
 * @version 1.0
 * Threadクラスを継承することに通じて、スレッドを立ち上げる
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        Cat cat = new Cat();
        cat.start();//start基底メソッドはrunメソッドを呼び出す
//        cat.run() runは通常メソッドであり、本格的にスレッドを起動させてない


        //mainスレッドと子スレッドが交互しながら実行を実現

        //mainスレッドを出力
        for(int i = 0; i < 80; i++){
            System.out.println("main thread i - " + i);
            //休止させる
            Thread.sleep(1000);
        }

    }
}
//あるクラスがスレッドクラスを継承したしたときに、そのクラスがスレッドとして扱える
//runメソッドは、スレッドのクラスであり、Runnableのインターフェースを実現
class Cat extends Thread{

    int times = 0;//回数変数を定義して、プロセス監視して統計する

    @Override
    public void run() {//runメソッドをオーバーライドして、自分の業務ロジックを書き込む

        while (true) {
            //一秒間隔で文字列を出力
            System.out.println("congratulations" + (++times));
            //スレッドに一秒単位の休止を入れる
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //回数が80回になった時に、無限ループを停止する
            //スレッドも終了ってことだ
            if (times == 8) {
                break;
            }
        }
    }
}
