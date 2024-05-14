package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.*;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * ファイル転送
 */
public class FileClientService {
    /**
     *
     * @param src
     * @param dest
     * @param senderId
     * @param getterId
     */
    public void sendFileToOne(String src, String dest, String senderId, String getterId) {

        //srcファイルを読み取る　-> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setDest(dest);
        message.setSrc(src);

        //ファイルを読み取る
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);//srcファイルをバイト文字列に読み込む
            //ファイルに応じたバイト配列をmessageに設置
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("\n" + senderId + " が　"
                + getterId + " に " + " ファイルを転送： " + src + " 相手のパスに： " + dest);

        //転送
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
