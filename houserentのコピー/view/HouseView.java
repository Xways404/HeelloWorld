package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utility;

/**
 * メニュー画面表示
 * ユーザー入力を受け取る
 * HouseServiceを呼び出して部屋のインフォを操作
 */
public class HouseView {
    private boolean loop = true; //メニュー画面をコントロール
    private char key = ' '; //ユーザー選択を受け取る
    private HouseService houseService = new HouseService(10); //配列を１０に設定

    //idに基づき、物件情報編集
    public void update() {
        System.out.println("===========物件情報編集============");
        System.out.println("物件idを入力して(-1でキャンセ)");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("===========キャンセやな===========");
            return;
        }
        //idに基づき、オブジェクト検索　
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("===========物件情報ID不明============");
        }
        System.out.print("名前("+house.getName()+"): ");
        String name = Utility.readString(8, "");
        if(!"".equals(name)) {
            house.setName(name);
        }
        System.out.print("電話("+house.getPhone()+"): ");
        String phone = Utility.readString(12, "");
        if(!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("住所("+house.getAddress()+"): ");
        String address = Utility.readString(18, "");
        if(!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("家賃("+house.getRent()+"): ");
        int rent = Utility.readInt();
        if(rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状態("+house.getState()+"): ");
        String state = Utility.readString(3, "");
        if(!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("===========物件情報修正完了============");

    }

    //idに基づいて物件情報を検索
    public  void findHouse() {
        System.out.println("===========物件情報検索============");
        System.out.println("物件情報を入力しなさい: ");
        int findId = Utility.readInt();
        //メソッドを呼び出し
        House house = houseService.findById((findId));
        if(house != null) {
            System.out.println(house);
        } else {
            System.out.println("===========物件情報ID不明============");
        }
    }

    //Utilityのメソッドで、確認手順を完成
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //delHouse()　ID入力を受け取る、Serviceを呼び出すdelメソッドを立ち上げ
    public void delHouse() {
        System.out.println("===========物件情報削除============");
        System.out.print("削除する物件ナンバーを入力(-1で退出");
        int delId = Utility.readInt();
        if(delId == -1) {
            System.out.println("===========物件情報削除を放置 ============");
            return;
        }
        System.out.println("削除するかを確認しなさい(Y/N)");
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y') {
            if(houseService.del(delId)) {
                System.out.println("===========物件情報削除完了============");
            } else {
                System.out.println("===========物件情報不明、削除失敗============");
            }

        } else {
            System.out.println("===========物件情報削除を放置 ============");
        }
    }

    //addHouse() 入力を受け取る、Houseオブジェクトを立ち上げ、addメソッドを呼び出し
    public void addHouse() {
        System.out.println("===========物件追加============");
        System.out.print("名前: ");
        String name = Utility.readString(8);
        System.out.print("電話: ");
        String phone = Utility.readString(12);
        System.out.print("住所: ");
        String address = Utility.readString(16);
        System.out.print("家賃: ");
        int rent = Utility.readInt();
        System.out.print("状態: ");
        String state = Utility.readString(3);
        //Houseオブジェクト作成、idはシステムが配布するものであり、ユーザーが入力することができない
        House newHouse = new House(0, name, phone, address, rent, state);
        if(houseService.add(newHouse)) {
            System.out.println("===========物件追加完了============");
        } else {
            System.out.println("===========物件追加失敗============");
        }

    }
    //ListHouses()物件一覧表を表示　
    public void listHouse(){
        System.out.println("===========物件一覧表============");
        System.out.println("番号\t\tオーナー\t\t電話\t\t住所\t\t家賃\t\t契約状況");
        House[] houses = houseService.list();//全ての物件情報を入手
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("===========物件一覧表表示完了============");
    }

    //メニュー表示
    public void mainMenu() {
        do{
            System.out.println("\n===========部屋賃貸システムのメニュー画面============");
            System.out.println("\t\t\t\t1 新 着 物 件");
            System.out.println("\t\t\t\t2 物 件 検 索");
            System.out.println("\t\t\t\t3 物 件 情 報 削 除");
            System.out.println("\t\t\t\t4 物 件 情 報 変 更");
            System.out.println("\t\t\t\t5 物 件 情 報 一 覧");
            System.out.println("\t\t\t\t6 退         出");
            System.out.println("1から６まで選んでください");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while(loop);


    }
}
