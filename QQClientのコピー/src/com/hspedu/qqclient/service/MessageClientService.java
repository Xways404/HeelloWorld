package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * このクラスはメッセージを関連するメソッドを提供
 */
public class MessageClientService {
    /**
     *
     * @param content
     * @param senderId
     */
    public void sendMessageToAll(String content, String senderId) {
        //messageを構築
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//通常チャット
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());//発送時間
        System.out.println(senderId + " が 全員 に " + content + " と伝えた");
        //サーバーサイドを発送
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream
                            (ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param content　　内容
     * @param senderId　発送されたあユーザーId
     * @param getterId　受け取ったユーザーId
     */
    public void sendMessageToOne(String content, String senderId, String getterId) {
        //messageを構築
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);//通常チャット
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new Date().toString());//発送時間
        System.out.println(senderId + " が " + getterId + " に " + content + " と伝えた");
        //サーバーサイドを発送
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream
                            (ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
