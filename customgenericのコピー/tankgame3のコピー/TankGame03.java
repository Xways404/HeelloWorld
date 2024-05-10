package com.hspedu.tankgame3;

import javax.swing.*;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class TankGame03 extends JFrame {

    //MyPanelを定義する
    MyPanel mp = null;

    public static void main(String[] args) {

        TankGame03 tankGame01 = new TankGame03();

    }

    public TankGame03() {
        mp = new MyPanel();
        //mpを　スレッドに入れて起動
        Thread thread = new Thread(mp);
        thread.start();//mpのrunメソッドを検知して実行
        this.add(mp);//パネル

        this.setSize(1200, 950);
        this.addKeyListener(mp);//JFrameにmpのキーボードイベントをリスナーさせる
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
