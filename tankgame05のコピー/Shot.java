package com.hspedu.tankgame05;

/**
 * @author Li Mi~
 * @version 1.0
 * 弾発射
 */
public class Shot implements Runnable{

    int x;//弾のx座標での移動情報
    int y;//弾のy座標での移動情報
    int direct = 0;//弾の移動方向
    int speed = 5;//発砲速度
    boolean isLive = true;//弾の存在性確認

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//発砲
        while (true) {

            //50ms休眠に入ってもらう、弾が発砲する間隔を作る
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //方向に従って、x　＆　y座標を変更していく
            switch (direct) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            //テスティングするために、ここでxy座標を出力して、弾の移動状況を確認
            System.out.println("Damnnnn X= " + x + " Y= " + y);
            //弾が境界端までに移動（到着）した時点で、自動廃棄起動（要は弾を起動するスレッドを廃棄）
            //弾が敵陣のタンクに当たった時、スレッドを終了すべき
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                System.out.println("発砲停止");
                isLive = false;
                break;
            }
        }
    }
}
