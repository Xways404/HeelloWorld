package com.hspedu.tankgame05;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * 爆発効果
 */
public class Bomb {
    int x, y; //爆弾の座標
    int life = 15;//爆弾のライフサイクル
    boolean islive = true;//残存状況

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //ライフ状況の減少
    public void lifeDown() {//爆発効果に合わせる
        if(life > 0) {
            life --;
        } else {
            islive = false;
        }
    }
}
