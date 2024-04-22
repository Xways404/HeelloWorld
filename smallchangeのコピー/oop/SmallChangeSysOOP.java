package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    String details = "-------------電子財布明細-------------";

    double money = 0;
    double balance = 0;
    Date date = null; //Dateはjava.util.Date,日付を表記　
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String note = "";


    public void mainMenu() {
        do {
            System.out.println("\n============== 電子財布OOP ==============");
            System.out.println("\t\t\t1 電子財布明細");
            System.out.println("\t\t\t2 収益入金");
            System.out.println("\t\t\t3 出金");
            System.out.println("\t\t\t4 退　　　　出");

            System.out.print("1から4を選択して");
            key = scanner.next();
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("選択エラー、やり直し");
            }

        } while(loop);
    }








    public void detail() {
        System.out.println(details);
    }
    public void income() {
        System.out.print("収益入金金額；");
        money = scanner.nextDouble();
        if(money <= 0) {
            System.out.println("収益の入金金額は０以上でなければ");
            return;
        }
        balance += money;
        date = new Date();

        details += "\n収益入金\t+" + money + "\t" + sdf.format(date) + "\t" + "残高：" + balance;
    }
    public void pay() {
        System.out.print("出金金額；");
        money = scanner.nextDouble();
        if(money <= 0 || money > balance) {
            System.out.println("出金金額は0から" + balance);
            return;
        }
        System.out.println("出金項目を入力: ");
        note = scanner.next();
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + "残高：" + balance;
    }
    public void exit() {
        String choice = "";
        while (true) {
            System.out.println("本当に退出してええか y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        if (choice.equals("y")) {
            loop = false;
        }
    }

}
