package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Li Mi~
 * @version 1.0
 * <p>
 * ユーザーログイン認証、ユーザー登録
 */
public class UserClientService {

    //他のとこでもUserの情報が必要とされるかも、だからメンバー属性にした
    private User u = new User();
    //socketは他のとこでも使う、属性にする
    private Socket socket;

    //userIdとpwdに基づき、サーバーサイドでユーザーの有効性を判断
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        //Userオブジェクト
        u.setUserId(userId);
        u.setPasswd(pwd);
        //サーバーサイドに接続して、uオブジェクトを発送

        try {
            socket = new Socket(InetAddress.getByName("192.168.1.16"), 9998);
            //ObjectOutputStreamオブジェクト
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//Userオブジェクトを送信

            //サーバーにさえされたMessageオブジェクトを読み取る
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            //メッセージタイプ判定
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {//ログイン完了

                //サーバーサイドを通信維持することができるスレッドを作成　→　スレッドクラスClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //クライアントサイドスレッド起動
                clientConnectServerThread.start();
                //クライアントサイドの拡張するために、スレッドをコレクションに入れて管理する
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                b = true;
            } else {
                //ログイン失敗した場合、サーバーと通信するスレッドを起動しない、ソケットを閉じる
                socket.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return b;
    }

    //サーバーサイドにオンラインユーザーリストをリクエストする
    public void onlineFriendList() {

        //Messageを送信、型はMESSAGE_GET_ONLINE_FRIENDで
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        //サーバーに発送する
        //このスレッドのソケットに応じたObjectOutputStreamオブジェクトを入手する
        try {
            //userIdに通じてスレッドを管理するコレクションからこのスレッドをゲット
            ClientConnectServerThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //スレッドに通じてソケットをゲット
            Socket socket = clientConnectServerThread.getSocket();
            //現在スレッドのソケットに応じるObjectOutPutStreamオブジェクトをゲット
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);//Messageオブジェクトを発送して、サーバーサイドにオンラインユーザーリストを請求
//            ObjectOutputStream oos =
//                    new ObjectOutputStream
//                            (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //メソッドをコールして、サーバーにシステム退出のmessageを発送
    public void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//どのクライアントサイドなのか指定しなさい

        //messageを発送
        try {
            //ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos =
                    new ObjectOutputStream
                            (ManageClientConnectServerThread.getClientConnectServerThread
                                    (u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " システム退出した");
            System.exit(0);//プロセス終了する
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
