package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ClientConnectServerThread extends Thread {
    //スレッドにソケットを持つ必要がある
    private Socket socket;

    //コンストラクタはSocketオブジェクトを受け取る
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    //今後サーバーサイドを関わるため、常に運行状態させる
    @Override
    public void run() {
        //スレッドがバックエンドでサーバーを通信する必要があるので、while繰り返し処理で
        while (true) {

            try {
                System.out.println("クライアントサイドはサーバーサイドから送信されたメッセージを読み取り待ち");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //もしサーバーがMessageオブジェクトを発送しなかったら、スレッドがここでつ詰まる
                Message message = (Message) ois.readObject();
                //メッセージの型を判定して、応じた業務処理を行う
                //読み取ったのが戻されたのはオンラインユーザーリストであれば
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //オンラインユーザーリストを取得して表示
                    //規定を立てる
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n=====現在のオンラインユーザーリスト=====");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("ユーザー：　" + onlineUsers[i]);
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //サーバーから転送されたメッセージを、コントロールバーに表示すればいい
                    System.out.println("\n" + message.getSender() + " が " + message.getGetter()
                            + " に " + message.getContent() + " と言った " + message.getSendTime());


                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    System.out.println("\n" + message.getSender() + " が全員に " + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println("\n" + message.getSender() + "　が　" + message.getGetter() +
                            " にファイルを転送: " + message.getSrc() + " to " + message.getDest());

                    //messageのファイルバイト配列を引き取ってファイル出力ストリームでディスクに書き込む
                    FileOutputStream fileOutputStream = new FileOutputStream((message.getDest()));
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n保存完了 ");


                } else {
                    System.out.println("その他のメッセージやから、とりあえず処理しない・・・・・");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

    }

    //Socketを獲得しやすいため
    public Socket getSocket() {
        return socket;
    }


}
