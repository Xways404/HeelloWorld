package com.hspedu.tankgame05;

import java.util.Vector;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable {

    //敵陣タンククラスで、Vector（スレッドセーフ確保）を使用して、多数のShotを保存
    Vector<Shot> shots = new Vector<>();
    //メンバーを増やす、EnemyTankは敵陣タンクのVectorを全て入手可能
    //Vector<EnemyTank>はMyPanelの中にある
    //setEnemyTanks
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //創建された時にすぐ殺されんよう
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //メソッドを提供して、MyPanelのメンバーを『Vector<EnemyTank> enemyTanks = new Vector<>();』
    //EnemyTankクラスに設置する
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //メソッドを作成、現在の敵タンクがenemyTanks中の他のタンクと被っているかを判断行う
    public boolean isTouchEnemyTank() {

        //現時点での敵タンク(this)の向き
        switch (this.getDirect()) {
            case 0://上
                //thisタンクに他の全タンクと比べさせる
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //vectorの中から敵陣のタンクを取り出す
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //自分とは比べない
                    if (enemyTank != this) {
                        //もし敵陣のタンクが上下であれば
                        //敵　　xの座標[enemyTank.getX(), enemyTank.getX() + 40]
                        //　　　yの座標[enemyTank.getY(), enemyTank.getX() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //我　　xの座標[this.getX(), this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 60) {
                                return true;
                            }
                            //     yの座標[this.getX() + 40, this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 60) {
                                return true;
                            }
                        }

                        //もし敵陣のタンクが左右であれば
                        //敵　　xの座標[enemyTank.getX() ,enemyTank.getX() + 60]
                        //　　　yの座標[enemyTank.getY() ,enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //thisタンク　左上【this.getX(),this.getY()】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //thisタンク　右上【this.getX() + 40,this.getY()】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX()  + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://左
                //this 敵タンクと全て比較
                for (int i = 0;i< enemyTanks.size();i++){
                    //vector中から敵タンクを取り出す
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //自分と比べない
                    if (this != enemyTank){
                        //x座標【enemyTank.getX() ,enemyTank.getX() + 40】
                        //y座標【enemyTank.getY(),enemyTank.getY()  + 40】
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //2.右上座標【this.getX() + 60,this.getY()】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //3.右下座標【this.getX() + 60,this.getY() + 40】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX()  + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY()  + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }

                        //x【enemyTank.getX(),enemyTank.getX() + 60】
                        //y【enemyTank.getY(),enemyTank.getX() + 40】
                        //左右
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //2.右上【this.getX() + 60,this.getY()】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            //3.右下【this.getX() + 60,this.getY()  + 40】
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                //this 敵タンク　全てと比較
                for (int i = 0;i< enemyTanks.size();i++){
                    //vector中から敵たんを引き出す
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //自分と比べない
                    if (this != enemyTank){
                        //x【enemyTank.getX() ,enemyTank.getX() + 40】
                        //y【enemyTank.getY(),enemyTank.getY()  + 60】
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //左下【this.getX(),this.getY() + 60】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                            //右下【this.getX() + 40,this.getY() + 60】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX()  + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY()  + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //x【enemyTank.getX(),enemyTank.getX() + 60】
                        //y【enemyTank.getY(),enemyTank.getX() + 40】
                        //左右
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //左下角【this.getX(),this.getY() + 60】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40){
                                return true;
                            }
                            //右下【this.getX() + 40,this.getY() + 60】
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX()  + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY()  + 60 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://右
                //this 敵タンク　全てと比較
                for (int i = 0;i< enemyTanks.size();i++){
                    //vector中から敵タンクを取り出す
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //自分と比べない
                    if (this != enemyTank){
                        //x【enemyTank.getX() ,enemyTank.getX() + 40】
                        //y【enemyTank.getY(),enemyTank.getY()  + 60】
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //左上【this.getX(),this.getY()】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            //左下【this.getX(),this.getY() + 40】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY()  + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //x【enemyTank.getX(),enemyTank.getX() + 60】
                        //y【enemyTank.getY(),enemyTank.getX() + 40】
                        //左右
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //左上【this.getX(),this.getY()】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            //左下【this.getX(),this.getY() + 40】
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY()  + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {
        while (true) {

            //shots size() = 0と判定したら,もう一個弾をshotsコレクションに
            if (isLive && shots.size() == 0) {

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
                            if (getY() > 0 && !isTouchEnemyTank()) {
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
                            if (getX() + 60 < 1000 && !isTouchEnemyTank()) {
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
                            if (getY() + 60 < 750 && !isTouchEnemyTank()) {
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
                            if (getX() > 0 && !isTouchEnemyTank()) {
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

