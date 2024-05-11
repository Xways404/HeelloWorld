package com.hspedu.tankgame05;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Li Mi~
 * @version 1.0
 * タンクバトルの図形描画作業場
 */
//キーボードイベントをリスナーするため、KeyListenerを実現
//Panelに継続的に弾を描くためには、MyPanelをRunnableインターフェースを実現させ、スレッドとして使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //タンクを定義する
    MyTank funky = null;
    //敵陣のタンクを定義する、Vectorコレクションに置く、マルチスレッドであるため
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //NodeオブVectorを定義、敵タンクのデータを復帰するため
    Vector<Node> nodes = new Vector<>();
    //Vectorを定義して、爆弾を保存する、ジェネリクスの使用
    //弾がタンクに当たったら、Bombオブジェクトに追加してbombsに
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 7;//大きさ変数を定義

    //爆弾のイメージ図を定義、爆発の効果を示す
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    Image image4 = null;

    public MyPanel(String key) {
        nodes = Recorder.getNodesAndEnemyTankNumRec();
        //MyPanelオブジェクトをenemyTanksをRecorderに
        Recorder.setEnemyTanks(enemyTanks);
        funky = new MyTank(100, 500);//タンク図形パネルの初期化

        //新規ゲームするか、継続戦うか
        switch (key) {
            case "1":
                for (int i = 0; i < enemyTankSize; i++) {
                //x軸の敵陣タンクの間隔が100として設定する場合　iのインデックスの値が0からやから、i+1
                EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
                //enemyTanksをenemyTankに設置する
                enemyTank.setEnemyTanks(enemyTanks);
                //敵陣タンクの向きを設定する
                enemyTank.setDirect(2);
                //敵陣のタンクスレッドを起動、動かしてやる
                new Thread(enemyTank).start();
                //敵陣タンクに弾を追加
                Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                //enemyTankのVectorメンバーに追加
                enemyTank.shots.add(shot);
                //追加だけで終わらん、起動しなければスレッドになん
                new Thread(shot).start();
                enemyTanks.add(enemyTank);
            }
                break;
            case "2"://continues
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    //x軸の敵陣タンクの間隔が100として設定する場合　iのインデックスの値が0からやから、i+1
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    //enemyTanksをenemyTankに設置する
                    enemyTank.setEnemyTanks(enemyTanks);
                    //敵陣タンクの向きを設定する
                    enemyTank.setDirect(node.getDirect());
                    //敵陣のタンクスレッドを起動、動かしてやる
                    new Thread(enemyTank).start();
                    //敵陣タンクに弾を追加
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    //enemyTankのVectorメンバーに追加
                    enemyTank.shots.add(shot);
                    //追加だけで終わらん、起動しなければスレッドになん
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("入力がおかしい、ちゃんとみろ");
        }

//        for (int i = 0; i < enemyTankSize; i++) {
//            //x軸の敵陣タンクの間隔が100として設定する場合　iのインデックスの値が0からやから、i+1
//            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
//            //enemyTanksをenemyTankに設置する
//            enemyTank.setEnemyTanks(enemyTanks);
//            //敵陣タンクの向きを設定する
//            enemyTank.setDirect(2);
//            //敵陣のタンクスレッドを起動、動かしてやる
//            new Thread(enemyTank).start();
//            //敵陣タンクに弾を追加
//            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
//            //enemyTankのVectorメンバーに追加
//            enemyTank.shots.add(shot);
//            //追加だけで終わらん、起動しなければスレッドになん
//            new Thread(shot).start();
//            enemyTanks.add(enemyTank);
//        }
        //初期化爆発効果イメージ図のオブジェクト
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb02.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/finger.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb02.gif"));

        image4 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/kunkun.gif"));
        
        //play music

    }

    //メソッドを作成、味方が敵を打撃した情報を表す
    public void showInfo(Graphics g) {

        g.setColor(Color.RED);
        Font font = new Font(" ", Font.BOLD, 20);
        g.setFont(font);

        //文字列データを表示
        g.drawString("#そなたが打撃した敵陣タンクの数", 1000, 30);
        //タンクのモデルを表示
        drawTank(1020, 60, g, 0, 0);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//塗りつぶし長方形を定義、デフォルトカラーブラック
        showInfo(g);//パネルにゲーム実況データを表示する

        if (funky != null && funky.isLive) {
            //タンクを描き出し、メソッドカプセル
            drawTank(funky.getX(), funky.getY(), g, funky.getDirect(), 1);
        }

        //Funkyが発砲した弾を描く
        if (funky.shot != null && funky.shot.isLive == true) {
            g.draw3DRect(funky.shot.x, funky.shot.y, 5, 5, false);
        }

        g.drawImage(image4, 200, 500, 100, 100, this);
        g.drawImage(image2, 300, 500, 100, 100, this);


        //funkyの弾コレクションshotsを走査し出し描く
//        for (int i = 0; i < funky.shots.size(); i++) {
//            Shot shot = funky.shots.get(i);
//            if (shot != null && shot.isLive == true) {
//                g.draw3DRect(shot.x, shot.y, 5, 5, false);
//            } else {//shotオブジェクトが無効になっていれば、shotsコレクションから排除
//                funky.shots.remove(shot);
//            }
//        }

        //もしbombsコレクションに爆弾があれば、drawout
        for (int i = 0; i < bombs.size(); i++) {
            //爆弾を取り出し
            Bomb bomb = bombs.get(i);
            //現在bombオブジェクトのライフ値に応じた爆発イメージ図を出す
            if (bomb.life > 10) {
                g.drawImage(image1, bomb.x, bomb.y, 100, 100, this);
            } else if (bomb.life > 5) {
                g.drawImage(image2, bomb.x, bomb.y, 180, 180, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 150, 150, this);
            }
            //爆弾のライフ値を減少させる
            bomb.lifeDown();
            //もしbomb　lifeが0になったら、bombsのコレクションから削除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }

        }

        //敵陣のタンクを描き、Vectorを走査して、何台存在しているのかを判断する
        for (int i = 0; i < enemyTanks.size(); i++) {
            //台数をゲット
            EnemyTank enemyTank = enemyTanks.get(i);
            //敵陣残存確認
            if (enemyTank.isLive == true) {//残存確認できた場合にしか、書き出さない
                //drawTankメソッドを呼び出し
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //enemyTankの弾を全て描き出す
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //弾を取り出し、一個目の弾
                    Shot shot = enemyTank.shots.get(j);
                    //描く
                    if (shot.isLive == true) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        //Vectorから削除ー弾が場外に出たからだ
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

    }

    //タンクを描き出しメソッド

    /**
     * @param x      左上のx座標
     * @param y      右上のy座標
     * @param g      　ペン
     * @param direct タンクの向き、上下左右
     * @param type   タンクタイプ（味方or敵）
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0://敵陣のタンク
                g.setColor(Color.cyan);
                break;
            case 1://味方のタンク
                g.setColor(Color.yellow);
                break;
        }
        //タンクの方向に従ってタンクを描き
        //0123　上下左右
        switch (direct) {
            case 0://上向
                //3Dだと立体感を表現できる
                g.fill3DRect(x, y, 10, 60, false);//タンクの左タイヤ
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中央ボディ
                g.fill3DRect(x + 30, y, 10, 60, false);//タンクの右タイヤ
                g.fillOval(x + 10, y + 20, 20, 20);//方向司令台
                g.drawLine(x + 20, y + 30, x + 20, y);//発砲銃
                break;
            case 1://右向
                //3Dだと立体感を表現できる
                g.fill3DRect(x, y, 60, 10, false);//タンクの左タイヤ
                g.fill3DRect(x, y + 30, 60, 10, false);//中央ボディ
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//タンクの右タイヤ
                g.fillOval(x + 20, y + 10, 20, 20);//方向司令台
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//発砲銃
                break;
            case 2://下向
                //3Dだと立体感を表現できる
                g.fill3DRect(x, y, 10, 60, false);//タンクの左タイヤ
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中央ボディ
                g.fill3DRect(x + 30, y, 10, 60, false);//タンクの右タイヤ
                g.fillOval(x + 10, y + 20, 20, 20);//方向司令台
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//発砲銃
                break;
            case 3://左向
                //3Dだと立体感を表現できる
                g.fill3DRect(x, y, 60, 10, false);//タンクの左タイヤ
                g.fill3DRect(x, y + 30, 60, 10, false);//中央ボディ
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//タンクの右タイヤ
                g.fillOval(x + 20, y + 10, 20, 20);//方向司令台
                g.drawLine(x + 30, y + 20, x, y + 20);//発砲銃
                break;
            default:
                System.out.println("暫定未処理");
        }
    }

    public void hitEnemyTank() {

        //弾を全走査
//        for (int j = 0; j < funky.shots.size(); j++) {
//            Shot shot = funky.shots.get(j);
//            //撃中してか判定する
//            if (shot != null && shot.isLive) { //弾が既存しておるかどうか
//
//                //敵陣のタンクを全走査
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(funky.shot, enemyTank);
//                }
//            }
//        }
        //単発
        if (funky.shot != null && funky.shot.isLive) { //弾が既存しておるかどうか
            //敵陣のタンクを全走査
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(funky.shot, enemyTank);
            }
        }
    }

    //敵陣のタンクが味方のタンクに的中したのか
    public void hitFunky() {
        //敵陣のタンクを全部走査する
        for (int i = 0; i < enemyTanks.size(); i++) {
            //敵陣タンク取り出し
            EnemyTank enemyTank = enemyTanks.get(i);
            //enemyTankオブジェクトの全ての弾を走査
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //弾を取り出す
                Shot shot = enemyTank.shots.get(j);
                //shotが我らのタンクに的中したのか
                if (funky.isLive && shot.isLive == true) {
                    hitTank(shot, funky);
                }
            }
        }
    }

    //このメソッドで、我が弾が敵陣のタンクに当たったかどうか判断する、
    //我が弾が敵陣を当たったかどうか、いつに判断すべきなのか？？？？？runで
    //今後enemyTank を　tankに
    public void hitTank(Shot s, Tank enemyTank) {
        //sが撃中したのか判断
        switch (enemyTank.getDirect()) {
            case 0: //0,2上下　x40 y60
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //いざ弾が相手のタンクに打撃を与えた場合には、enemyTankをコレクションから外す
                    enemyTanks.remove(enemyTank);
                    //我が敵陣タンクを打撃したたび、allEnemyTankNum++する
                    //enemyTank funkyもEnemyTankも
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    //Bombを作成して、bombsコレクションに追加
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //1,3左右 x60 y40
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //いざ弾が相手のタンクに打撃を与えた場合には、enemyTankをコレクションから外す
                    enemyTanks.remove(enemyTank);
                    //Bombを作成して、bombsコレクションに追加
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //wdsa上下左右処理
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//Wキーを押した状態の実況
            //タンクの方向を変える 上
            funky.setDirect(0);
            //タンクの座標を修正して、移動を実現する
            //上ならy軸なので、直接に書かず、メソッドにカプセルする
            if (funky.getY() > 0) {
                funky.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //右
            funky.setDirect(1);
            if (funky.getX() + 60 < 1000) {
                funky.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            //下
            funky.setDirect(2);
            if (funky.getY() + 60 < 750) {
                funky.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            //左
            funky.setDirect(3);
            if (funky.getX() > 0) {
                funky.moveLeft();
            }
        }
        //ユーザーがJキーを押したら、発砲する
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //funkyの弾が消滅するか　一個
            if (funky.shot == null || !funky.shot.isLive) {
                funky.shotEnemyTank();
            }

            //多発
//            funky.shotEnemyTank();

        }
        //再描き
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //我の弾が奴らに当たったのか
            hitEnemyTank();

            //敵陣が我らを的中したのか
            hitFunky();

            //描き繰り返し
            this.repaint();
        }
    }
}
