package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Li Mi~
 * @version 1.0
 * サーバーサイド、9999ポートをリスナーしている、クライアントサイドを接続待ちながら通信を保つ
 */
public class QQServer {

    private ServerSocket ss = null;
    //コレクションを作成、多数のユーザーを入れ、これらのユーザーであれば有効であると認定
    //ConcurrentHashMapは並行コレクションの処理を実現し、スレッドセーフの問題が発生しない
    //HashMapにはスレッドセーフを処理できない、そのためマルチスレッドではノーセーフである
    //ConcurrentHashMapはスレッドセーフであり、スレッド同期である、マルチスレッドでもセーフである
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();

    static {//静的コードブロックで、validUsersを初期化

        //ユーザー立ち上げ
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("田中", new User("田中", "123456"));
        validUsers.put("宮城誠一", new User("宮城誠一", "123456"));
        validUsers.put("宇智波佐助", new User("宇智波佐助", "123456"));

    }

    //ユーザーが有効なのかを検証するメソッド
    private boolean checkUser(String userId, String passwd) {

        User user = validUsers.get(userId);
        //各箇所に検証を入れる
        if (user == null) {//空であれば、userIdがvalidUsersのキー値に存在していないと示す
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {//userIdの確認ができたけど、パスワードが不正
            return false;
        }
        return true;

    }

    public QQServer() {
        //ポートは設定ファイルに書き込める
        try {
            System.out.println("サーバーサイドが9999ポートでリスナーしてる");
            //ニューススレッドを起動
            new Thread(new SendNewsToAllService()).start();
            ss = new ServerSocket(9998);

            while (true) {//あるクライアントと接続した後、継続リスナさせるためwhile繰り返し処理する
                Socket socket = ss.accept();
                //socketと関連するオブジェクトの入力ストリームを得る
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());

                //socketに関連するオブジェクト出力ストリーム
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();//クライアントサイドが発送されたUserオブジェクトを読み取る
                //Messageオブジェクトを立ち上げ、クライアントサイドに返す準備
                Message message = new Message();
                //検証 //ユーザー検証のためにメソッドを作成 checkUserを導入
                if (checkUser(u.getUserId(), u.getPasswd())) {//有効ユーザー
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //messageオブジェクトを返す
                    oos.writeObject(message);
                    //スレッドを作成して、クライアントサイドとの通信を維持する、
                    //スレッドにソケットオブジェクトを持つ必要がある
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());
                    //スレッドを起動する
                    serverConnectClientThread.start();
                    //このスレッドオブジェクトをコレクション入れて管理する
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);



                } else {//登録失敗
                    System.out.println("ユーザーID = " + u.getUserId() + " pwd = " + u.getPasswd() + " 認証失敗");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //登録失敗したら、ソケットを閉じなかん
                    socket.close();
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //サーバーがwhileから退出すれば、サーバーサイドがリスナーしないと示す、ServerSocketを閉じる
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
