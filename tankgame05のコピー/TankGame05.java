package com.hspedu.tankgame05;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class TankGame05 extends JFrame {

    //MyPanelを定義する
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        TankGame05 tankGame01 = new TankGame05();

    }

    public TankGame05() {
        System.out.println("選択しろー　１：ニューゲーム　２：継続");
        String key = scanner.next();
        mp = new MyPanel(key);
        //mpを　スレッドに入れて起動
        Thread thread = new Thread(mp);
        thread.start();//mpのrunメソッドを検知して実行
        this.add(mp);//パネル

        this.setSize(1350, 750);

        this.addKeyListener(mp);//JFrameにmpのキーボードイベントをリスナーさせる
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //JFrameでウィンドを閉じる処理を追加
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
