package com.hspedu.smallchange;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String details = "-------------電子財布明細-------------";

        double money = 0;
        double balance = 0;
        Date date = null; //Dateはjava.util.Date,日付を表記　
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String note = "";

        do {

            System.out.println("\n============== 電子財布 ==============");
            System.out.println("\t\t\t1 電子財布明細");
            System.out.println("\t\t\t2 収益入金");
            System.out.println("\t\t\t3 出金");
            System.out.println("\t\t\t4 退　　　　出");

            System.out.print("1から4を選択して");
            key = scanner.next();
            switch(key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("収益入金金額；");
                    money = scanner.nextDouble();
                    if(money <= 0) {
                        System.out.println("収益の入金金額は０以上でなければ");
                        break;
                    }
                    balance += money;
                    date = new Date();

                    details += "\n収益入金\t+" + money + "\t" + sdf.format(date) + "\t" + "残高：" + balance;
                    break;
                case "3":
                    System.out.print("出金金額；");
                    money = scanner.nextDouble();
                    if(money <= 0 || money > balance) {
                        System.out.println("出金金額は0から" + balance);
                        break;
                    }
                    System.out.println("出金項目を入力: ");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + "残高：" + balance;
                    break;
                case "4":
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

                    break;
                default:
                    System.out.println("選択エラー、やり直し");
            }


        } while (loop);
        System.out.println("-----電子財布プロジェクト終了-----");
    }
}
