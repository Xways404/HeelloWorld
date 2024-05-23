package com.hspedu.mhl.view;

import com.hspedu.mhl.domain.*;
import com.hspedu.mhl.service.BillService;
import com.hspedu.mhl.service.DiningTableService;
import com.hspedu.mhl.service.EmployeeService;
import com.hspedu.mhl.service.MenuService;
import com.hspedu.mhl.utils.Utility;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class MHLView {

    //メインメニューから退出するかをコントロール
    private boolean loop = true;
    private String key = "";//ユーザーの入力を受け取る
    //EmployeeServiceオブジェクトを定義する
    private EmployeeService employeeService = new EmployeeService();
    //DiningTableServiceオブジェクトをコール
    private DiningTableService diningTableService = new DiningTableService();
    //MenuService定義
    private MenuService menuService = new MenuService();
    //BillService定義
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //会計
    public void payBill() {
        System.out.println("=============　会　計　=============");
        System.out.print("会計卓番を選んで(-1): ");
        int dindingTableId = Utility.readInt();
        if (dindingTableId == -1) {
            System.out.println("=========会計キャン=========");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableById(dindingTableId);
        if (diningTable == null) {
            System.out.println("=========会計キャン=========");
            return;
        }
        if (!billService.hasPayBillByDiningTableId(dindingTableId)) {
            System.out.println("=========会計キャン=========");
            return;
        }
        System.out.print("支払い方法を選んで(現金/支付宝/微信): ");
        String payMode = Utility.readString(20, "");
        if ("".equals(payMode)) {
            System.out.println("=========会計キャン=========");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {
            if (billService.payBill(dindingTableId, payMode)) {
                System.out.println("===========会計OK===========");
            } else {
                System.out.println("会計失敗・・・・・・・・");
            }
        } else {
            System.out.println("=========会計キャン=========");
        }

    }

    //伝票情報を表示
    public void listBill() {
//        List<Bill> Bills = billService.list();
//        System.out.println("\n伝番\t\t品番\t\t品量\t\t金額\t\t卓番\t日付\t\t\t\t\t\t\t状況");
//        for (Bill bill : Bills) {
//            System.out.println(bill);
//        }
        List<MultiTableBean> multiTableBeans = billService.list2();
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态\t\t菜品名\t\t价格");
        for (MultiTableBean bill : multiTableBeans) {
            System.out.println(bill);
        }
        System.out.println("=============表示済み=============");
    }

    //オーダー実現
    public void orderMenu() {
        System.out.println("=============オーダーサービス=============");
        System.out.println("オーダーされた卓番を入力(-1): ");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("=============オーダーキャンセル=============");
            return;
        }
        System.out.println("オーダーされた品番を入力(-1): ");
        int orderMenuId = Utility.readInt();
        if (orderMenuId == -1) {
            System.out.println("=============オーダーキャンセル=============");
            return;
        }
        System.out.println("オーダーされた数量を入力(-1): ");
        int orderNums = Utility.readInt();
        if (orderNums == -1) {
            System.out.println("=============オーダーキャンセル=============");
            return;
        }
        //卓番の存在を検証
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("=============卓番不在=============");
            return;
        }
        //品番の存在を検証
        Menu menuById = menuService.getMenuById(orderMenuId);
        if (menuById == null) {
            System.out.println("=============品番不在=============");
        }
        //オーダー
        if (billService.orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
            System.out.println("=============オーダー完了=============");
        } else {
            System.out.println("=============オーダー失敗=============");
        }
    }

    //メニュー表示
    public void listMenu() {
        System.out.println("\n品番号\t\t品名\t\t\t類別\t\t価格");
        List<Menu> list = menuService.list();
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("=============表示済み=============");
    }

    //席予約機能を実現
    public void orderDiningTable() {
        System.out.println("=============席予約=============");
        System.out.println("予約したい卓番を記入(-1で退出) : ");
        int orderId = Utility.readInt();
        if (orderId == -1) {
            System.out.println("=============予約キャンセル=============");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {//予約する

            //orderIdに基づき、応じたDiningTableを戻す、nullであればそのオブジェクトが不存在
            DiningTable diningTable = diningTableService.getDiningTableById(orderId);
            if (diningTable == null) {
                System.out.println("=============予約席が不在=============");
                return;
            }
            //空席なのか判断
            if (!("空".equals(diningTable.getState()))) {//当席は空席ではないと示す
                System.out.println("=============予約不可=============");
                return;
            }
            //予約情報を受け取る
            System.out.print("予約名 : ");
            String orderName = Utility.readString(50);
            System.out.print("予約電話 : ");
            String orderTel = Utility.readString(50);

            //ここでガチで予約段階に入る、席情報を更新
            if (diningTableService.orderDiningTable(orderId, orderName, orderTel)) {
                System.out.println("=============予約完了=============");
            } else {
                System.out.println("=============予約不可=============");
            }

        } else {
            System.out.println("=============予約キャンセル=============");
        }

    }

    //席状況を表示
    public void listDiningTable() {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n卓番号\t\t席状況");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("=============表示済み=============");
    }

    //メインメニュー表示
    public void mainMenu() {
        while (loop) {
            System.out.println("=============満漢楼=============");
            System.out.println("\t\t 1 満漢楼登録");
            System.out.println("\t\t 2 満漢楼退出");
            System.out.print("選択してください：　");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.println("従業員　番　号　を入力：　");
                    String empId = Utility.readString(50);
                    System.out.println("従業員パスワードを入力：　");
                    String pwd = Utility.readString(50);
                    //データベースで判断を行う
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee != null) {//ユーザーが存在している
                        System.out.println("========ログイン完了[" + employee.getName() + "]========");
                        //サブメニュー表示、繰り返し操作なので、whileにする
                        while (loop) {
                            System.out.println("=============満漢楼(サブメニュー)=============");
                            System.out.println("\t\t 1 席状況表示");
                            System.out.println("\t\t 2 席予約");
                            System.out.println("\t\t 3 メニュー表示");
                            System.out.println("\t\t 4 オーダーサービス");
                            System.out.println("\t\t 5 会計伝票");
                            System.out.println("\t\t 6 会計");
                            System.out.println("\t\t 9 退出");
                            System.out.print("選択してください：　");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    listDiningTable();//席状況を表示
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                default:
                                    System.out.println("入力エラー、入力し直しください・・・");
                            }
                        }
                    } else {
                        System.out.println("========ログイン不能========");
                    }
                    break;
                case "2":
                    loop = false;//ループ終了
                    break;
                default:
                    System.out.println("入力エラー、入力し直しください・・・");
            }
        }
        System.out.println("満漢楼システムから退出されました");
    }
}
