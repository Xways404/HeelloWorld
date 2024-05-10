package com.hspedu.tankgame3;

import java.util.Vector;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable {

    //敵陣タンククラスで、Vector（スレッドセーフ確保）を使用して、多数のShotを保存
    Vector<Shot> shots = new Vector<>();
    //創建された時にすぐ殺されんよう
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {

            //shots size() = 0と判定したら,もう一個弾をshotsコレクションに
            if(isLive && shots.size() == 0) {

                Shot s = null;

                //タンクの向きを判定して、それに応じる弾を作る
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }

            //もしshots size() = 0,弾を一個作成して、入れる
            //shotsコレクション、起動
            if (isLive && shots.size() < 10) {

                Shot s = null;

                //タンクの方向を判定して、応じた弾を設定
                switch (getDirect()) {
                    case 0:
                        //タンクに一つの方向に保持して、３０歩を移動させる
                        for (int i = 0; i < 30; i++) {
                            if (getY() > 0) {
                                moveUp();
                            }
                            //休眠50ms
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 1:
                        for (int i = 0; i < 30; i++) {
                            if (getX() + 60 < 1000) {
                                moveRight();
                            }
                            //休眠50ms
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 30; i++) {
                            if (getY() + 60 < 750) {
                                moveDown();
                            }
                            //休眠50ms
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 30; i++) {
                            if (getX() > 0) {
                                moveLeft();
                            }
                            //休眠50ms
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                }
            }
            //休眠50ms
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //ランダムに方向転換する
            setDirect((int) (Math.random() * 4));
            //いざマルチスレッド並行プロセスを書くときに、絶対的にこのスレッドの終了タイミングを考えなけりゃ
            if (!isLive) {
                break;//getout thread
            }
        }
    }
}

