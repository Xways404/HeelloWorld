package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

/**
 * HouseService クラス　業務層
 * House[]を定義、Houseオブジェクトを保存
 * HouseViewの呼び出しをレスポンス
 * 部屋情報の各操作を完成する
 */
public class HouseService {

    private House[] houses;
    private int houseNums = 1;//物件データ何件あるかを記録
    private int idCounter = 1;//IDのインクリメントがどこまで増加されたかを記録

    //コンストラクター
    public HouseService(int size) {
        // new houses
        houses = new House[size];
        //Houseオブジェクトを初期化する
        houses[0] = new House(1, "田中", "112", "北区", 2000, "未契約");
    }

    //findByIdメソッドを作成、Houseオブジェクトor　nullを返す
    public House findById(int findId) {
        for(int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }

    //delメソッド物件情報を削除
    public boolean del(int delId) {
        //削除する物件情報のインデックスを見つけなければならぬ
        int index = -1;
        for(int i = 1; i < houseNums; i++) {
            if(delId == houses[i].getId()) {
                index = i;
            }
        }
        if(index == -1) {
            return false;
        }
        for(int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums] = null;
        return true;
    }

    //addメソッド、オブジェクトを追加して、booleanで返す
    public boolean add(House newHouse) {
        //まだ追加できるかを判断する
        if(houseNums == houses.length) {
            System.out.println("配列満タン、これ以上追加できない...");
            return false;
        }
        //newHouseオブジェクトを新しく追加された物件に入れる
        houses[houseNums++] = newHouse;
        //IDのインクリメントを設計する
//        idCounter++;
        newHouse.setId(++idCounter);
        return true;
    }


    //listメソッド,housesバック
    public House[] list(){
        return houses;
    }


}
