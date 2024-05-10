package com.hspedu.tankgame3;

import java.util.Vector;

/**
 * @author Li Mi~
 * @version 1.0
 * わいらのドリームビッグタンク
 */
public class MyTank extends Tank {
    //Shotオブジェクトを定義,発砲行為を表す（スレッド）
    Shot shot = null;
    //弾を多発させる
//    Vector<Shot> shots = new Vector<>();

    public MyTank(int x, int y) {
        super(x, y);
    }

    //発砲メソッド
    public void shotEnemyTank() {

        //パネル表示において、最大５弾しか発射させない
//        if(shots.size() == 5) {
//            return;
//        }

        switch (getDirect()) {
            case 0://上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2://下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }

        //新規VectorShotをshotsに入れる
//        shots.add(shot);

        //Shotスレッドを起動
        new Thread(shot).start();
    }
}
