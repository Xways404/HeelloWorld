package com.hspedu.tankgame05;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Tank {
    private int x;//タンクの横座標
    private int y;//タンクの縦座標
    private int direct;//タンク方向
    private int speed = 5;//タンクの走行速度を定義
    boolean isLive = true;

    //上下左右移動するメソッド
    public void moveUp() {//上
        y -= speed;
    }
    public void moveRight() {//右
        x += speed;
    }
    public void moveDown() {//下
        y += speed;
    }
    public void moveLeft() {//左
        x -= speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
