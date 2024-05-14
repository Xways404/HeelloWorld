package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Li Mi~
 * @version 1.0
 * このクラスのオブジェクトがあるクライアントサイドと通信をキープしてる
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId;//サーバーサイドに接続されたユーザーid

    public ServerConnectClientThread(Socket socket, String ussrId) {
        this.socket = socket;
        this.userId = ussrId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {//送信受信状態を常に保つ

        while (true) {
            try {
                System.out.println("サーバーサイドとクライアントサイド" + userId + "の通信をキープしてデータを読み取る・・・");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //messageの型によって、対応した業務処理を行う
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //クライアントサイドがオンラインユーザーリストをリクエスト
                    /*
                    オンラインユーザーリストの形式 100 200 宮城誠一
                     */
                    System.out.println(message.getSender() + "　がオンラインユーザーリストをリクエスト中");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //messageを返す
                    //Messageオブジェクトを構築して、クライアントサイドに返す
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //データルート（ソケット）に書き込む、クライアントサイドに返す
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);


                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //messageに基づきgetteridを獲得、そして応じたスレッドをゲット
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    //応じたソケットオブジェクトの出力ストリームを得て、messageを指定されたクライアントサイドに転送
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);//転送、クライアントがオフラインであれば、データベースに保存できる、そしたらオフラインメッセージできる

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //スレッドを管理してるコレクションを走査
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();

                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String onLineUserId = iterator.next().toString();
                        if (!onLineUserId.equals(message.getSender())) {//排除する
                            //転送を行う
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //getterIdに応じたスレッドをゲットしてmessageに転送
                    ServerConnectClientThread serverConnectClientThread =
                            ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//クライアントサイド退出

                    System.out.println(message.getSender() + " 退出");
                    //クライアントサイドが対応するスレッドをコレクションから削除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    //ソケットを閉じる
                    socket.close();
                    //スレッドから退出
                    break;

                } else {
                    System.out.println("その他の型はとりあえず無視・・・・・");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

}
