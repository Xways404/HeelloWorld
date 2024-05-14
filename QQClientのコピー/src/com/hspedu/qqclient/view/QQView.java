package com.hspedu.qqclient.view;

import com.hspedu.qqclient.service.FileClientService;
import com.hspedu.qqclient.service.MessageClientService;
import com.hspedu.qqclient.service.UserClientService;
import com.hspedu.qqclient.utils.Utility;

import static com.hspedu.qqclient.utils.Utility.readString;

/**
 * @author Li Mi~
 * @version 1.0
 * <p>
 * クライアントサイドメニュー画面
 */
public class QQView {

    private boolean loop = true;//メニュー表示をコントロール
    private String key = "";//ユーザーの入力情報
    //このオブジェクトはログイン・ユーザー登録用である
    private UserClientService userClientService = new UserClientService();//ログイン登録
    private MessageClientService messageClientService = new MessageClientService();//メッセージ,chat
    private FileClientService fileClientService = new FileClientService();//ファイル転送

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("クライアントサイドシステム退出・・・・・");
    }

    //メインメニューを表示
    private void mainMenu() {

        while (loop) {
            System.out.println("============ようこそネット通信へ============");
            System.out.println("\t\t1 システムログイン");
            System.out.println("\t\t9 システム退出");
            System.out.print("機能ナンバーを入力してください : ");

            key = readString(1);

            //ユーザーの入力によって、それぞれの業務ロジックを処理
            switch (key) {
                case "1":
                    System.out.print("ユーザー名 : ");
                    String userId = readString(50);
                    System.out.print("パスワード : ");
                    String pwd = readString(50);
                    //サーバーサイドでユーザーを検証しないといけない
                    //クラスを作成、UserClientService[ログイン・登録]
                    if (userClientService.checkUser(userId, pwd)) {
                        System.out.println("========== (ユーザー　" + userId + " 登録完了) ようこそサブメニューへ==========");
                        //サブメニューに入る
                        while (loop) {
                            System.out.println("\n========ネットワーク通信サブメニュー(ユーザー　" + userId + " )==========");
                            System.out.println("\t\t 1 オンラインユーザーリスト");
                            System.out.println("\t\t 2 グループメッセージ");
                            System.out.println("\t\t 3 個人メッセージ");
                            System.out.println("\t\t 4 ファイル送信");
                            System.out.println("\t\t 9 退出システム");
                            System.out.print("機能ナンバーを入力してください : ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    //メソッドを作成して、オンラインユーザーリストを入手
                                    //System.out.println("オンラインユーザーリスト");
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("みんなに言いたいこと言え");
                                    String s = Utility.readString(100);
                                    //メソッドを呼び出し、メッセージをサーバーに送る
                                    messageClientService.sendMessageToAll(s, userId);
                                    break;
                                case "3":
                                    System.out.print("どいつとチャットしたいか、そいつのユーザー名を書いて : ");
                                    String getterId = Utility.readString(50);
                                    System.out.print("言いたいことを言え : ");
                                    String content = readString(100);
                                    //メッセージをサーバーサイドに送る
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
                                    System.out.println("ファイルを発送したいユーザーを書いて：");
                                    getterId = Utility.readString(50);
                                    System.out.println("発送のパス：　");
                                    String src = Utility.readString(100);
                                    System.out.println("相手先のパス：　");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src, dest, userId, getterId);
                                    break;
                                case "9":
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }

                        }
                    } else {
                        System.out.println("==========ログイン失敗==========");
                    }
                    break;
                case "9":
                    //メソッドをコールして、サーバーにシステム退出のmessageを発送
                    userClientService.logout();
                    loop = false;
                    break;
            }
        }

    }
}
