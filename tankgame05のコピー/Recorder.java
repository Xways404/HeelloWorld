package com.hspedu.tankgame05;

import java.io.*;
import java.util.Vector;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * このクラスはゲームに関するデータを記録する、ファイル交互
 */
public class Recorder {

    //変数を定義して、打撃した敵陣タンクの数を記録する
    private static int allEnemyTankNum = 0;
    //IOストリームのオブジェクトを定義する
    //データをファイルに書き込む用に
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "/Users/xways404/news1.txt";
    //Vectorを定義して、MyPanelオブジェクトの敵陣タンクのVectorに指す
    private static Vector<EnemyTank> enemyTanks = null;
    //NodeのVectorを定義する、敵のデータを保存する用
    private static Vector<Node> nodes = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //メソッドを追加して、recordFileを読み取って、関連データを復帰
    public static Vector<Node> getNodesAndEnemyTankNumRec() {

        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //繰り返し読み取り、Nodeコレクションを形成
            String line = "";
            while((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    //メソッドを作成、ゲームが終了後に、allEnemyTankNumをrecordFileに保存
    //敵陣タンクの座標と方向
    //
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");
            //敵陣タンクのVectorを走査して、状況に応じて保存すればいい
            //oop思考から考えると、属性を定義して、setXXで敵陣タンクのVector獲得
            for(int i = 0; i < enemyTanks.size(); i++) {
                //敵陣のタンクを取り出し
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive){//判断したほうがいい
                    //このenemyTankのデータを保存
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                    //ファイルに書き込む
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //我が敵陣のタンクを打撃したたびに、allEnemyTankNum++にする
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }

}
